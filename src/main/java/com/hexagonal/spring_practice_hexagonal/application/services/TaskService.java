package com.hexagonal.spring_practice_hexagonal.application.services;


import com.hexagonal.spring_practice_hexagonal.domain.models.AdditionalTaskInfo;
import com.hexagonal.spring_practice_hexagonal.domain.models.Task;
import com.hexagonal.spring_practice_hexagonal.domain.ports.in.CreateTaskUseCase;
import com.hexagonal.spring_practice_hexagonal.domain.ports.in.DeleteTaskUseCase;
import com.hexagonal.spring_practice_hexagonal.domain.ports.in.GetAdditionalTaskInfoUseCase;
import com.hexagonal.spring_practice_hexagonal.domain.ports.in.RetrieveTaskUseCase;
import com.hexagonal.spring_practice_hexagonal.domain.ports.in.UpdateTaskUseCase;

import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class TaskService implements CreateTaskUseCase, RetrieveTaskUseCase, UpdateTaskUseCase, DeleteTaskUseCase, GetAdditionalTaskInfoUseCase{

    private final CreateTaskUseCase createTaskUseCase;
    private final RetrieveTaskUseCase retrieveTaskUseCase;
    private final UpdateTaskUseCase updateTaskUseCase;
    private final DeleteTaskUseCase deleteTaskUseCase;
    private final GetAdditionalTaskInfoUseCase getAdditionalTaskInfoUseCase;


    @Override
    public Task createTask(Task task) {        
        return createTaskUseCase.createTask(task);
    }

    @Override
    public List<Task> getAllTasks() {        
        return retrieveTaskUseCase.getAllTasks();
    }

    @Override
    public Optional<Task> getTask(Long id) {        
        return retrieveTaskUseCase.getTask(id);
    }

    @Override
    public Optional<Task> updateTask(Long id, Task updateTask) {        
        return updateTaskUseCase.updateTask(id, updateTask);
    }

    @Override
    public boolean deleteTask(Long id) {        
        return deleteTaskUseCase.deleteTask(id);
    }

    @Override
    public AdditionalTaskInfo getAdditionalTaskInfo(Long id) {        
        return getAdditionalTaskInfoUseCase.getAdditionalTaskInfo(id);
    }    
}
