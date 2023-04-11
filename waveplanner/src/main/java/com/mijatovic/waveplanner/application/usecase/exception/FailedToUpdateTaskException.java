package com.mijatovic.waveplanner.application.usecase.exception;

import com.mijatovic.waveplanner.exception.ModelException;

/**
 * An exception thrown when a requested task update operation fails.
 */
public class FailedToUpdateTaskException extends ModelException {

    /**
     * Constructs a new {@code FailedToUpdateTaskException} with the default detail message.
     */
    public FailedToUpdateTaskException() {
        super("Failed to update task.");
    }
}
