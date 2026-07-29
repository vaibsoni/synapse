package com.vaibhav.synapse.user.dto;

import com.vaibhav.synapse.user.entity.UserRole;

import java.time.LocalDateTime;
import java.util.UUID;

public record UserResponse(

        UUID id,
        String firstName,
        String lastName,
        String email,
        String phoneNumber,
        UserRole role,
        LocalDateTime createdAt

) {
}
