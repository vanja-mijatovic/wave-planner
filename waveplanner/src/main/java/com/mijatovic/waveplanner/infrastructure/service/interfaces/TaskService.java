package com.mijatovic.waveplanner.infrastructure.service.interfaces;

import com.mijatovic.waveplanner.application.usecase.exception.FailedToAddTaskException;
import com.mijatovic.waveplanner.application.usecase.exception.FailedToUpdateTaskException;
import com.mijatovic.waveplanner.application.usecase.exception.ResourceNotFoundException;
import com.mijatovic.waveplanner.model.entity.Task;

import java.math.BigDecimal;
import java.util.List;

/**
 * This interface represents the Task service which provides methods for managing tasks.
 */
public interface TaskService {

    /**
     * Returns a list of all tasks.
     *
     * @return a list of tasks
     */
    List<Task> getTasks();

    /**
     * Retrieves the task with the specified ID.
     *
     * @param id The ID of the task to retrieve.
     * @return The Task object with the specified ID.
     * @throws ResourceNotFoundException If no task exists with the given ID.
     */
    Task getTask(BigDecimal id);

    /**
     * Adds a new task to the repository and returns the added task.
     *
     * @param task The task to add to the repository.
     * @return The added task.
     * @throws FailedToAddTaskException if the task could not be added to the repository.
     */
    Task addTask(Task task);

    /**
     * Updates an existing task in the system.
     *
     * @param task The updated Task object.
     * @throws FailedToUpdateTaskException if the update operation fails for any reason.
     */
    void updateTask(Task task);
}
