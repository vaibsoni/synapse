package com.vaibhav.synapse.common.controller;

import com.vaibhav.synapse.common.response.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/v1")
public class HealthController {

    /**Even though Actuator is already there in the project, I've created this endpoint
     * just to verify controller structure, ApiResponse<T> etc.
     * */
    @GetMapping("/health")
    public ResponseEntity<ApiResponse<String>> healthHandler() {

        ApiResponse<String> response = ApiResponse.<String>builder()
                .timestamp(LocalDateTime.now())
                .status(200)
                .message("Application is running")
                .data("Some response data")
                .build();
        return ResponseEntity.ok(response);
    }


}
