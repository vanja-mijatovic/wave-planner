package com.mijatovic.waveplanner.infrastructure.service.implementation;

import com.mijatovic.waveplanner.infrastructure.repository.interfaces.TaskRepository;
import com.mijatovic.waveplanner.infrastructure.service.interfaces.TaskService;
import com.mijatovic.waveplanner.model.entity.Task;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

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
    public List<Task> getTasks(){
        return taskRepository.findAll();
    }

    /**
     * Retrieves an Optional object containing a Task with the specified ID, if one exists.
     *
     * @param id The ID of the task to retrieve.
     * @return An Optional object containing the Task with the specified ID, or an empty Optional if no task exists with the given ID.
     */
    @Override
    public Optional<Task> getTask(BigDecimal id){
        return taskRepository.findById(id);
    }

    /**
     * Creates a new task.
     *
     * @param task The task to create.
     * @return The created task.
     */
    @Override
    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    /**
     * Updates a task with the specified id.
     *
     * @param id The id of the task to update.
     * @param task The task with updated data.
     * @return The updated task.
     */
    @Override
    public Task updateTask(BigDecimal id, Task task) {
        return taskRepository.save(task);
    }
}
