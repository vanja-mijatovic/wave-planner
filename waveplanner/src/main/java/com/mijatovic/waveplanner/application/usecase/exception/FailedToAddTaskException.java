package com.mijatovic.waveplanner.application.usecase.exception;

import com.mijatovic.waveplanner.exception.ModelException;

/**
 * An exception that is thrown when a new task fails to be added to the system.
 */
public class FailedToAddTaskException extends ModelException {

    /**
     * Constructs a new {@code FailedToAddTaskException} with the default detail message.
     */
    public FailedToAddTaskException() {
        super("Failed to add new task.");
    }
}
