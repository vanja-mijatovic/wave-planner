package com.mijatovic.waveplanner.application.usecase.implementation;

import com.mijatovic.waveplanner.application.usecase.interfaces.UseCase;
import com.mijatovic.waveplanner.dto.TaskDTO;
import com.mijatovic.waveplanner.dto.mapper.TaskDTOMapper;
import com.mijatovic.waveplanner.service.implementation.TaskServiceImplementation;
import com.mijatovic.waveplanner.model.entity.Task;
import lombok.AllArgsConstructor;
import lombok.Value;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * Use case that updates an existing task with the fields provided in the taskDTO.
 */
@Service
@AllArgsConstructor
public class UpdateTask implements UseCase<UpdateTask.UpdateTaskInput, UpdateTask.UpdateTaskOutput> {

    private final TaskDTOMapper taskDTOMapper;
    private final TaskServiceImplementation taskService;

    /**
     * Input values for the UpdateTask use case, containing the task ID and the updated taskDTO.
     */
    @Value
    @AllArgsConstructor(staticName = "of")
    public static class UpdateTaskInput implements InputValues {
        private final BigDecimal taskId;
        private final TaskDTO taskDTO;
    }

    /**
     * Output values for the UpdateTask use case, containing the updated taskDTO.
     */
    @Value
    @AllArgsConstructor(staticName = "of")
    public static class UpdateTaskOutput implements OutputValues {
        private final TaskDTO updatedTaskDTO;
    }

    /**
     * Executes the use case to update an existing task with the fields provided in the taskDTO.
     *
     * @param input The input for the use case, containing the task ID and the updated taskDTO.
     * @return An UpdateTaskOutput object containing the updated taskDTO.
     */
    @Override
    public UpdateTaskOutput execute(UpdateTaskInput input) {
        validateNotNull(input);
        Task existingTask = taskService.getTask(input.getTaskId());
        Task updatedTask = updateTaskFields(existingTask, input.getTaskDTO());
        taskService.updateTask(updatedTask);
        TaskDTO updatedTaskDTO = taskDTOMapper.apply(updatedTask);
        return UpdateTaskOutput.of(updatedTaskDTO);
    }

    private Task updateTaskFields(Task existingTask, TaskDTO taskDTO) {
        existingTask.setTitle(taskDTO.title());
        existingTask.setType(taskDTO.type());
        existingTask.setDueDate(taskDTO.dueDate());
        existingTask.setDescription(taskDTO.description());
        return existingTask;
    }
}
