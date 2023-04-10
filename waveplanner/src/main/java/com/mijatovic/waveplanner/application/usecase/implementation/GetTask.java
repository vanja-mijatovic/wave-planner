package com.mijatovic.waveplanner.application.usecase.implementation;

import com.mijatovic.waveplanner.application.usecase.exception.ResourceNotFoundException;
import com.mijatovic.waveplanner.application.usecase.interfaces.UseCase;
import com.mijatovic.waveplanner.dto.TaskDTO;
import com.mijatovic.waveplanner.dto.mapper.TaskDTOMapper;
import com.mijatovic.waveplanner.infrastructure.service.implementation.TaskServiceImplementation;
import com.mijatovic.waveplanner.model.entity.Task;
import lombok.AllArgsConstructor;
import lombok.Value;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * Use case that retrieves a single task based on its ID.
 */
@Service
@AllArgsConstructor
public class GetTask implements UseCase<GetTask.GetTaskInput, GetTask.GetTaskOutput> {

    private final TaskDTOMapper taskDTOMapper;
    private final TaskServiceImplementation taskServiceImplementation;

    /**
     * Value class for encapsulating the input to the use case.
     */
    @Value
    @AllArgsConstructor(staticName = "of")
    public static class GetTaskInput implements InputValues{
        private final BigDecimal taskId;
    }

    /**
     * Value class for encapsulating the output of the use case.
     */
    @Value
    @AllArgsConstructor(staticName = "of")
    public static class GetTaskOutput implements OutputValues{
        private final TaskDTO taskDTO;
    }

    /**
     * Executes the use case to retrieve a single task based on its ID.
     *
     * @param input The input for the use case, which contains the task ID.
     * @return A GetTaskOutput object containing the task retrieved by the use case.
     * @throws ResourceNotFoundException if the task with the specified ID is not found.
     */
    @Override
    public GetTaskOutput execute(GetTaskInput input) {
        validateNotNull(input);
        Task task = taskServiceImplementation.getTask(input.getTaskId()).orElseThrow(() -> new ResourceNotFoundException());
        TaskDTO taskDTO = taskDTOMapper.apply(task);
        return GetTaskOutput.of(taskDTO);
    }
}
