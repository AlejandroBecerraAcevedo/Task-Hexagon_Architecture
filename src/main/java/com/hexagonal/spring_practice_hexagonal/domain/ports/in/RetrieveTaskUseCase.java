package com.hexagonal.spring_practice_hexagonal.domain.ports.in;

import com.hexagonal.spring_practice_hexagonal.domain.models.Task;

import java.util.List;
import java.util.Optional;

public interface RetrieveTaskUseCase {
    Optional<Task> getTask(Long id);
    List<Task> getAllTasks();
}
