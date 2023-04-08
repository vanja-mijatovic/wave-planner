package com.mijatovic.waveplanner.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * This exception is thrown when a requested resource cannot be found.
 * The HTTP status code associated with this exception is {@link org.springframework.http.HttpStatus#NOT_FOUND}.
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    /**
     * Constructs a new {@code NotFoundException} with the specified detail message.
     *
     * @param message the detail message.
     */
    public NotFoundException(String message) {
        super(message);
    }

}
