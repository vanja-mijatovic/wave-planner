package com.mijatovic.waveplanner.infrastructure.service.implementation;

import com.mijatovic.waveplanner.application.usecase.exception.FailedToAddTaskException;
import com.mijatovic.waveplanner.application.usecase.exception.FailedToUpdateTaskException;
import com.mijatovic.waveplanner.application.usecase.exception.ResourceNotFoundException;
import com.mijatovic.waveplanner.infrastructure.repository.interfaces.TaskRepository;
import com.mijatovic.waveplanner.infrastructure.service.interfaces.TaskService;
import com.mijatovic.waveplanner.model.entity.Task;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

/**
 * Implementation of the TaskService interface that provides methods to retrieve, create and update tasks.
 */
@Service
@AllArgsConstructor
public class TaskServiceImplementation implements TaskService {

    private TaskRepository taskRepository;

    /**
     * Retrieves all tasks.
     *
     * @return A list of all tasks.
     */
    @Override
    public List<Task> getTasks() {
        return taskRepository.findAll();
    }

    /**
     * Retrieves the task with the specified ID.
     *
     * @param id The ID of the task to retrieve.
     * @return The Task object with the specified ID.
     * @throws ResourceNotFoundException If no task exists with the given ID.
     */
    @Override
    public Task getTask(BigDecimal id) {
        return taskRepository.findById(id)
                .orElseThrow(ResourceNotFoundException::new);
    }

    /**
     * Adds a new task to the repository and returns the added task.
     *
     * @param task The task to add to the repository.
     * @return The added task.
     * @throws FailedToAddTaskException if the task could not be added to the repository.
     */
    @Override
    public Task addTask(Task task) throws FailedToAddTaskException {
        try {
            return taskRepository.save(task);
        } catch (Exception e) {
            throw new FailedToAddTaskException();
        }
    }

    /**
     * Updates an existing task in the system.
     *
     * @param task The updated Task object.
     * @throws FailedToUpdateTaskException if the update operation fails for any reason.
     */
    @Override
    public void updateTask(Task task) {
        try {
            taskRepository.save(task);
        } catch (Exception e) {
            throw new FailedToUpdateTaskException();
        }
    }
}
