package com.mijatovic.waveplanner.exception;

import org.springdoc.api.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.NoSuchElementException;

/**
 * This class serves as a global exception handler for the application. It extends the ResponseEntityExceptionHandler
 * class and provides methods to handle different types of exceptions.
 */
@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    /**
     * Handles ModelException by returning an ErrorMessage with the exception message.
     * @param modelException the ModelException to be handled
     * @return an ErrorMessage with the exception message
     */
    @ExceptionHandler(ModelException.class)
    public ErrorMessage badRequestException(ModelException modelException){
        return new ErrorMessage(modelException.getMessage());
    }

    /**
     * Handles AlreadyExistsException by returning an ErrorMessage with the exception message.
     * @param alreadyExistsException the AlreadyExistsException to be handled
     * @return an ErrorMessage with the exception message
     */
    @ExceptionHandler(AlreadyExistsException.class)
    public ErrorMessage conflictException(AlreadyExistsException alreadyExistsException){
        return new ErrorMessage(alreadyExistsException.getMessage());
    }

    /**
     * Handles NotFoundException by returning an ErrorMessage with the exception message.
     * @param notFoundException the NotFoundException to be handled
     * @return an ErrorMessage with the exception message
     */
    @ExceptionHandler(NotFoundException.class)
    public ErrorMessage notFoundException(NotFoundException notFoundException){
        return new ErrorMessage(notFoundException.getMessage());
    }

    /**
     * Handles NoSuchElementException by returning an ErrorMessage with the exception message.
     * @param noSuchElementException the NoSuchElementException to be handled
     * @return an ErrorMessage with the exception message
     */
    @ExceptionHandler(NoSuchElementException.class)
    public ErrorMessage noSuchElementException(NoSuchElementException noSuchElementException){
        return new ErrorMessage(noSuchElementException.getMessage());
    }

    /**
     * Exception handler method for handling {@link IllegalAccessException}.
     * Returns an HTTP 403 (Forbidden) status code and a message indicating that the user does not have
     * sufficient permissions to access the requested resource.
     *
     * @param ex the {@link IllegalAccessException} object to handle.
     * @return an {@link ErrorMessage} object containing a message indicating that the user does not have sufficient permissions to access the requested resource.
     */
    @ExceptionHandler(IllegalAccessException.class)
    @ResponseStatus(value = HttpStatus.FORBIDDEN)
    public ErrorMessage handleIllegalAccessException(IllegalAccessException ex) {
        return new ErrorMessage("You do not have sufficient permissions to access this resource");
    }
}

