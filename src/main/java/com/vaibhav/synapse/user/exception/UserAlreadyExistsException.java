package com.vaibhav.synapse.user.exception;

import com.vaibhav.synapse.common.exception.ResourceAlreadyExistsException;

public class UserAlreadyExistsException extends ResourceAlreadyExistsException {


    public UserAlreadyExistsException() {
        super("User with this email already exists.");
    }

    public UserAlreadyExistsException(String message) {
        super(message);
    }

}
