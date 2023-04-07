package com.mijatovic.waveplanner.infrastructure.repository.interfaces;

import com.mijatovic.waveplanner.model.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;

/**
 * Repository interface for performing CRUD operations on {@link Task} entities.
 */
public interface TaskRepository extends JpaRepository<Task, BigDecimal> { }
