package com.vaibhav.synapse.user.mapper;

import com.vaibhav.synapse.user.dto.CreateUserRequest;
import com.vaibhav.synapse.user.dto.UserResponse;
import com.vaibhav.synapse.user.entity.User;
import com.vaibhav.synapse.user.entity.UserRole;

public final class UserMapper {

    private UserMapper() {
    }

    public static User toEntity(CreateUserRequest request) {
        return User.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .password(request.password())
                .phoneNumber(request.phoneNumber())
                .build();
    }

    public static UserResponse toResponse(User user) {
        return new UserResponse(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail(),
                user.getPhoneNumber(),
                user.getRole(),
                user.getCreatedAt(),
                user.getUpdatedAt()
        );
    }
}
