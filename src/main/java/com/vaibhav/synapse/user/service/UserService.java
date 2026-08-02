package com.vaibhav.synapse.user.service;

import com.vaibhav.synapse.user.dto.CreateUserRequest;
import com.vaibhav.synapse.user.dto.UserResponse;
import com.vaibhav.synapse.user.entity.User;
import com.vaibhav.synapse.user.entity.UserRole;
import com.vaibhav.synapse.user.exception.UserAlreadyExistsException;
import com.vaibhav.synapse.user.mapper.UserMapper;
import com.vaibhav.synapse.user.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserResponse registerUser(CreateUserRequest request) {
        log.info("Registering user with email={}", request.email());
        if (userRepository.existsByEmail(request.email())) {
            log.warn("Registration failed. User already exists with email={}", request.email());
            throw new UserAlreadyExistsException();
        }
        User user = UserMapper.toEntity(request);
        user.setRole(UserRole.USER);
        User createdUser = userRepository.save(user);
        log.info("User registered successfully. userId={}, email={}", createdUser.getId(), createdUser.getEmail());
        return UserMapper.toResponse(createdUser);
    }


}
