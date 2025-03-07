package com.hexagonal.spring_practice_hexagonal.domain.ports.in;

import com.hexagonal.spring_practice_hexagonal.domain.models.Task;

public interface CreateTaskUseCase {
    Task createTask(Task task);    
}
