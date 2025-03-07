package com.hexagonal.spring_practice_hexagonal.application.usecases;

import com.hexagonal.spring_practice_hexagonal.domain.models.Task;
import com.hexagonal.spring_practice_hexagonal.domain.ports.in.CreateTaskUseCase;
import com.hexagonal.spring_practice_hexagonal.domain.ports.out.TaskRepositoryPort;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CreateTaskUseCaseImplementation implements CreateTaskUseCase {

    private final TaskRepositoryPort taskRepositoryPort;

    @Override
    public Task createTask(Task task) {
        return taskRepositoryPort.save(task);
    }
  

    
}
