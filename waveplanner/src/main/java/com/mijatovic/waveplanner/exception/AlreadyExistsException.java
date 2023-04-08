package com.mijatovic.waveplanner.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * This exception is thrown when an attempt is made to create or modify a resource that already exists.
 * The HTTP status code associated with this exception is {@link org.springframework.http.HttpStatus#CONFLICT}.
 */
@ResponseStatus(value = HttpStatus.CONFLICT)
public class AlreadyExistsException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    /**
     * Constructs a new {@code AlreadyExistsException} with the specified detail message.
     *
     * @param message the detail message.
     */
    public AlreadyExistsException(String message) {
        super(message);
    }

}
