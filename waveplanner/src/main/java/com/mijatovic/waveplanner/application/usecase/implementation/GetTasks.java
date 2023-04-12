package com.mijatovic.waveplanner.application.usecase.implementation;

import com.mijatovic.waveplanner.application.usecase.interfaces.UseCase;
import com.mijatovic.waveplanner.dto.TaskDTO;
import com.mijatovic.waveplanner.dto.mapper.TaskDTOMapper;
import com.mijatovic.waveplanner.service.implementation.TaskServiceImplementation;
import com.mijatovic.waveplanner.model.entity.Task;
import lombok.AllArgsConstructor;
import lombok.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * This class represents a use case for getting a list of tasks. It implements the UseCase interface,
 * which defines the standard use case structure.
 * <p>
 * The class uses a TaskDTOMapper and a TaskServiceImplementation to retrieve a list of tasks and
 * map them to a list of TaskDTOs.
 */
@Service
@AllArgsConstructor
public class GetTasks implements UseCase<UseCase.VoidInput, GetTasks.GetTasksOutput> {

    private final TaskDTOMapper taskDTOMapper;
    private final TaskServiceImplementation taskServiceImplementation;

    /**
     * This class represents the output values of the GetTasks use case. It encapsulates a list of
     * TaskDTO objects.
     */
    @Value
    @AllArgsConstructor(staticName = "of")
    public static class GetTasksOutput implements OutputValues {
        /**
         * The list of TaskDTO objects returned by the use case.
         */
        private final List<TaskDTO> tasks;
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
        List<TaskDTO> taskDTOS = mapTasksToDTOs(tasks);
        return GetTasksOutput.of(taskDTOS);
    }

    /**
     * Maps a list of Task objects to a list of TaskDTO objects using the TaskDTOMapper.
     *
     * @param tasks The list of Task objects to map to TaskDTO objects.
     * @return A list of TaskDTO objects.
     */
    private List<TaskDTO> mapTasksToDTOs(List<Task> tasks) {
        return tasks.stream().map(taskDTOMapper).collect(Collectors.toList());
    }
}
