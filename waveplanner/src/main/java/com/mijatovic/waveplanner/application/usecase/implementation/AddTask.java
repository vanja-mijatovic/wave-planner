package com.mijatovic.waveplanner.application.usecase.implementation;

import com.mijatovic.waveplanner.application.usecase.interfaces.UseCase;
import com.mijatovic.waveplanner.dto.TaskDTO;
import com.mijatovic.waveplanner.dto.mapper.TaskDTOMapper;
import com.mijatovic.waveplanner.infrastructure.service.implementation.TaskServiceImplementation;
import com.mijatovic.waveplanner.model.entity.Task;
import lombok.AllArgsConstructor;
import lombok.Value;
import org.springframework.stereotype.Service;

/**
 * Use case that adds a new task.
 */
@Service
@AllArgsConstructor
public class AddTask implements UseCase<AddTask.AddTaskInput, AddTask.AddTaskOutput> {

    private final TaskDTOMapper taskDTOMapper;
    private final TaskServiceImplementation taskService;

    /**
     * Value class for encapsulating the input to the use case.
     */
    @Value
    @AllArgsConstructor(staticName = "of")
    public static class AddTaskInput implements UseCase.InputValues {
        private final TaskDTO taskDTO;
    }

    /**
     * Value class for encapsulating the output of the use case.
     */
    @Value
    @AllArgsConstructor(staticName = "of")
    public static class AddTaskOutput implements UseCase.OutputValues {
        private final TaskDTO addedTaskDTO;
    }

    /**
     * Executes the use case to add a new task.
     *
     * @param input The input for the use case, which contains the task information.
     * @return An OutputValues object containing the task added by the use case.
     */
    @Override
    public AddTaskOutput execute(AddTaskInput input) {
        validateNotNull(input);
        Task task = mapToTaskObject(input.getTaskDTO());
        Task addedTask = taskService.addTask(task);
        TaskDTO addedTaskDTO = taskDTOMapper.apply(addedTask);
        return AddTaskOutput.of(addedTaskDTO);
    }

    /**
     * Maps a TaskDTO object to a Task object.
     *
     * @param taskDTO The TaskDTO object to be mapped.
     * @return A new Task object with the mapped properties.
     */
    private Task mapToTaskObject(TaskDTO taskDTO) {
        return Task.builder()
                .title(taskDTO.title())
                .type(taskDTO.type())
                .dueDate(taskDTO.dueDate())
                .description(taskDTO.description())
                .build();
    }
}
