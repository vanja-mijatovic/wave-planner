package com.mijatovic.waveplanner.application.usecase.exception;

import com.mijatovic.waveplanner.exception.ModelException;

/**
 * An exception thrown when a requested resource is not found.
 */
public class ResourceNotFoundException extends ModelException {

    /**
     * Constructs a new {@code ResourceNotFoundException} with the default detail message.
     */
    public ResourceNotFoundException() {
        super("Resource not found.");
    }
}
