package com.hexagonal.spring_practice_hexagonal.domain.ports.out;

import java.util.List;
import java.util.Optional;

import com.hexagonal.spring_practice_hexagonal.domain.models.Task;

public interface TaskRepositoryPort {
    Task save(Task task);
    Optional<Task> findById(Long id);
    List<Task> findAll();
    Optional<Task> update(Task task);
    boolean deleteById(Long id);
}
