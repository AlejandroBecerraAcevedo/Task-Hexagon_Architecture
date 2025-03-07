package com.hexagonal.spring_practice_hexagonal.domain.ports.in;

public interface DeleteTaskUseCase {
    boolean deleteTask(Long id);
}
