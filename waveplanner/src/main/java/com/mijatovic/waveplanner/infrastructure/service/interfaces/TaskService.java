package com.mijatovic.waveplanner.infrastructure.service.interfaces;

import com.mijatovic.waveplanner.model.entity.Task;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

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
     * Retrieves an Optional object containing a Task with the specified ID, if one exists.
     *
     * @param id The ID of the task to retrieve.
     * @return An Optional object containing the Task with the specified ID, or an empty Optional if no task exists with the given ID.
     */
    Optional<Task> getTask(BigDecimal id);

    /**
     * Creates a new task.
     *
     * @param task the task to create
     * @return the created task
     */
    Task createTask(Task task);

    /**
     * Updates an existing task with the specified ID.
     *
     * @param id the ID of the task to update
     * @param task the updated task object
     * @return the updated task
     */
    Task updateTask(BigDecimal id, Task task);
}
