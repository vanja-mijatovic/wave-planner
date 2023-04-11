package com.mijatovic.waveplanner.dto;

import lombok.Getter;

import java.math.BigDecimal;
import java.util.Date;

/**
 * A value class representing a Task data transfer object (DTO).
 * Encapsulates the properties of a Task object for transferring data between layers of the application.
 */
@Getter
public record TaskDTO(
        BigDecimal id,
        String title,
        String type,
        Date dueDate,
        String description
) {
}
