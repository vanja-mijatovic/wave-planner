package com.mijatovic.waveplanner.dto.mapper;

import com.mijatovic.waveplanner.dto.TaskDTO;
import com.mijatovic.waveplanner.model.entity.Task;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class TaskDTOMapper implements Function<Task, TaskDTO> {

    /**
     * Maps a Task object to a TaskDTO object.
     *
     * @param task The Task object to be mapped.
     * @return A new TaskDTO object with the mapped properties.
     */
    @Override
    public TaskDTO apply(Task task){
        return new TaskDTO(
                task.getId(),
                task.getTitle(),
                task.getType(),
                task.getDueDate(),
                task.getDescription()
        );
    }
}
