package com.hexagonal.spring_practice_hexagonal.application.usecases;

import com.hexagonal.spring_practice_hexagonal.domain.models.Task;
import com.hexagonal.spring_practice_hexagonal.domain.ports.in.RetrieveTaskUseCase;
import com.hexagonal.spring_practice_hexagonal.domain.ports.out.TaskRepositoryPort;

import java.util.List;
import java.util.Optional;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class RetrieveTaskUseCaseImplementation implements RetrieveTaskUseCase {
    private final TaskRepositoryPort taskRepositoryPort;

    @Override
    public List<Task> getAllTasks() {
        return taskRepositoryPort.findAll();
    }

    @Override
    public Optional<Task> getTask(Long id) {
        return taskRepositoryPort.findById(id);
    }

   
    
}
