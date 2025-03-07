package com.hexagonal.spring_practice_hexagonal.application.usecases;


import java.util.Optional;

import com.hexagonal.spring_practice_hexagonal.domain.models.Task;
import com.hexagonal.spring_practice_hexagonal.domain.ports.in.UpdateTaskUseCase;
import com.hexagonal.spring_practice_hexagonal.domain.ports.out.TaskRepositoryPort;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UpdateTaskUseCaseImplementation implements UpdateTaskUseCase {
    private final TaskRepositoryPort taskRepositoryPort;

    @Override
    public Optional<Task> updateTask(Long id, Task updateTask) {
        return taskRepositoryPort.update(updateTask);
    }    
}
