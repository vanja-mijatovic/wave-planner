package com.mijatovic.waveplanner.controller;

import com.mijatovic.waveplanner.application.usecase.implementation.AddTask;
import com.mijatovic.waveplanner.application.usecase.implementation.GetTask;
import com.mijatovic.waveplanner.application.usecase.implementation.GetTasks;
import com.mijatovic.waveplanner.application.usecase.implementation.UpdateTask;
import com.mijatovic.waveplanner.application.usecase.interfaces.UseCase;
import com.mijatovic.waveplanner.dto.TaskDTO;
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

    private final AddTask addTaskUseCase;
    private final GetTask getTaskUseCase;
    private final UpdateTask updateTaskUseCase;
    private final GetTasks getTasksUseCase;

    /**
     * Gets a list of all tasks.
     *
     * @return A List of TaskDTO objects representing the tasks.
     */
    @GetMapping
    public List<TaskDTO> getTasks() {
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
     * Adds a new task with the given task details.
     *
     * @param taskDTO The {@link TaskDTO} object representing the task to be added.
     * @return The {@link TaskDTO} object representing the newly added task.
     */
    @PostMapping
    public TaskDTO addTask(@RequestBody TaskDTO taskDTO) {
        return addTaskUseCase.execute(AddTask.AddTaskInput.of(taskDTO)).getAddedTaskDTO();
    }

    /**
     * Updates a task with the specified ID using the provided TaskDTO.
     *
     * @param taskDTO The TaskDTO containing the new values for the task.
     * @param id      The ID of the task to update.
     * @return The updated TaskDTO.
     */
    @PutMapping("/{id}")
    public TaskDTO updateTask(@RequestBody TaskDTO taskDTO, @PathVariable BigDecimal id) {
        return updateTaskUseCase.execute(UpdateTask.UpdateTaskInput.of(id, taskDTO)).getUpdatedTaskDTO();
    }
}
