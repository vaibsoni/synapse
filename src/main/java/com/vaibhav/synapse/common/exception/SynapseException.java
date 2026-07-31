package com.vaibhav.synapse.common.exception;

public abstract class SynapseException extends RuntimeException {

    protected SynapseException(String message) {
        super(message);
    }

    protected SynapseException(String message, Throwable cause) {
        super(message, cause);
    }
}