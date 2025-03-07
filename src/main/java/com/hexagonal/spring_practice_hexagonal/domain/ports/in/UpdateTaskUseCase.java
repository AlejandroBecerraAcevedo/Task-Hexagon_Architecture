package com.hexagonal.spring_practice_hexagonal.domain.ports.in;

import com.hexagonal.spring_practice_hexagonal.domain.models.Task;
import java.util.Optional;

public interface UpdateTaskUseCase {
    Optional<Task> updateTask(Long id, Task updateTask);    
}
