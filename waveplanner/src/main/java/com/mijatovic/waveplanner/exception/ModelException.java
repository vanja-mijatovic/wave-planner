package com.mijatovic.waveplanner.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * This exception is thrown when there is an issue with the input model, such as missing or invalid data.
 * The HTTP status code associated with this exception is {@link org.springframework.http.HttpStatus#BAD_REQUEST}.
 */
@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class ModelException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    /**
     * Constructs a new {@code ModelException} with the specified detail message.
     *
     * @param message the detail message.
     */
    public ModelException(String message) {
        super(message);
    }

}
