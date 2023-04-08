package com.mijatovic.waveplanner.exception;

import org.springdoc.api.ErrorMessage;
import org.springframework.web.bind.annotation.ExceptionHandler;
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
}

