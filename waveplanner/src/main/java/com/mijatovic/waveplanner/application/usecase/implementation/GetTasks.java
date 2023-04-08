package com.mijatovic.waveplanner.application.usecase.implementation;

import com.mijatovic.waveplanner.application.usecase.interfaces.UseCase;
import com.mijatovic.waveplanner.infrastructure.service.implementation.TaskServiceImplementation;
import com.mijatovic.waveplanner.model.entity.Task;
import lombok.AllArgsConstructor;
import lombok.Value;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Implementation of the UseCase interface for getting a list of tasks.
 */
@Service
@AllArgsConstructor
public class GetTasks implements UseCase<UseCase.VoidInput, GetTasks.GetTasksOutput> {

    private TaskServiceImplementation taskServiceImplementation;

    /**
     * Value class for encapsulating the list of tasks returned by the use case.
     */
    @Value
    @AllArgsConstructor(staticName = "of")
    public static class GetTasksOutput implements OutputValues{
        private final List<Task> tasks;
    }

    /**
     * Executes the use case to get a list of tasks.
     *
     * @param input The input for the use case, which is void in this case.
     * @return A GetTasksOutput object containing the list of tasks returned by the use case.
     */
    @Override
    public GetTasksOutput execute(VoidInput input) {
        List<Task> tasks = taskServiceImplementation.getTasks();
        return GetTasksOutput.of(tasks);
    }
}

