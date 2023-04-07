package com.mijatovic.waveplanner.web.controller;

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

    private TaskServiceImplementation taskServiceImplementation;

    /**
     * Get a list of all tasks.
     *
     * @return List of Task objects.
     */
    @GetMapping
    public List<Task> getTasks(){
        return taskServiceImplementation.getTasks();
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
