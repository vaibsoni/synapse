package com.vaibhav.synapse.user.controller;

import com.vaibhav.synapse.common.response.ApiResponse;
import com.vaibhav.synapse.user.dto.CreateUserRequest;
import com.vaibhav.synapse.user.dto.UserResponse;
import com.vaibhav.synapse.user.service.UserService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@Slf4j
@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService userService;
//    private static final Logger log = LoggerFactory.getLogger(UserController.class);//instead of this, use lombok annotation @Slf4j


    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<ApiResponse<UserResponse>> registerUser(@Valid @RequestBody CreateUserRequest request) {
        log.info("Received user registration request for email={}", request.email());
        UserResponse response = userService.registerUser(request);
        ApiResponse<UserResponse> apiResponse = new ApiResponse<>();
        apiResponse.setTimestamp(LocalDateTime.now());
        apiResponse.setStatus(HttpStatus.CREATED.value());
        apiResponse.setMessage("User registered successfully.");
        apiResponse.setData(response);

        return ResponseEntity.status(HttpStatus.CREATED).body(apiResponse);
    }

}
