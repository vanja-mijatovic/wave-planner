package com.mijatovic.waveplanner.model.entity;

import lombok.*;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Represents a task entity.
 *
 * @property id - The unique identifier of the task.
 * @property title - The title of the task.
 * @property type - The type of the task.
 * @property dueDate - The due date of the task.
 * @property description - The description of the task.
 */
@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private BigDecimal id;
    @Column(nullable = false)
    private String title;
    private String type;
    @Column(name = "due_date")
    private Date dueDate;
    private String description;
}