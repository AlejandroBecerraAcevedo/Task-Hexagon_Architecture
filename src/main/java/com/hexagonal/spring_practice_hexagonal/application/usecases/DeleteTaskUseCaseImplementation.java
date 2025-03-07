package com.hexagonal.spring_practice_hexagonal.application.usecases;

import com.hexagonal.spring_practice_hexagonal.domain.ports.in.DeleteTaskUseCase;
import com.hexagonal.spring_practice_hexagonal.domain.ports.out.TaskRepositoryPort;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DeleteTaskUseCaseImplementation implements DeleteTaskUseCase {
    private final TaskRepositoryPort taskRepositoryPort;

    @Override
    public boolean deleteTask(Long id) {
        return taskRepositoryPort.deleteById(id);
    }
}
