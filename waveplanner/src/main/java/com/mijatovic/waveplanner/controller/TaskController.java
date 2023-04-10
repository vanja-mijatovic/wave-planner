package com.mijatovic.waveplanner.controller;

import com.mijatovic.waveplanner.application.usecase.implementation.GetTask;
import com.mijatovic.waveplanner.application.usecase.implementation.GetTasks;
import com.mijatovic.waveplanner.application.usecase.interfaces.UseCase;
import com.mijatovic.waveplanner.dto.TaskDTO;
import com.mijatovic.waveplanner.infrastructure.service.implementation.TaskServiceImplementation;
import com.mijatovic.waveplanner.model.entity.Task;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

/**
 * Controller for handling Task related requests.
 */
@RestController
@RequestMapping("/api/task")
@CrossOrigin("*")
@AllArgsConstructor
public class TaskController {

    private final GetTask getTaskUseCase;
    private final GetTasks getTasksUseCase;
    private final TaskServiceImplementation taskServiceImplementation;

    /**
     * Gets a list of all tasks.
     *
     * @return A List of TaskDTO objects representing the tasks.
     */
    @GetMapping
    public List<TaskDTO> getTasks(){
        return getTasksUseCase.execute(new UseCase.VoidInput()).getTasks();
    }

    /**
     * Retrieves a single task with the specified ID.
     *
     * @param id the ID of the task to retrieve.
     * @return a TaskDTO object representing the retrieved task.
     */
    @GetMapping("/{id}")
    public TaskDTO getTask(@PathVariable BigDecimal id) {
        return getTaskUseCase.execute(GetTask.GetTaskInput.of(id)).getTaskDTO();
    }

    /**
     * Add a new task.
     *
     * @param task Task object to be added.
     * @return Newly added Task object.
     */
    @PostMapping
    public Task addTask(@RequestBody Task task){
        return taskServiceImplementation.createTask(task);
    }

    /**
     * Update an existing task.
     *
     * @param task Task object with updated details.
     * @param id Id of the Task to be updated.
     * @return Updated Task object.
     */
    @PutMapping("/{id}")
    public Task updateTask(@RequestBody Task task, @PathVariable BigDecimal id){
        return taskServiceImplementation.updateTask(id, task);
    }
}
