package com.mijatovic.waveplanner.application.usecase.exception;

import com.mijatovic.waveplanner.exception.ModelException;

/**
 * An exception thrown when the input provided to a use case is invalid.
 */
public class InvalidInputException extends ModelException {

    /**
     * Constructs a new {@code InvalidInputException} with the specified detail message.
     *
     * @param message the detail message.
     */
    public InvalidInputException(String message) {
        super(message);
    }
}
