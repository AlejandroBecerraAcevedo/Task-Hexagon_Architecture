package com.hexagonal.spring_practice_hexagonal.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.hexagonal.spring_practice_hexagonal.application.usecases.CreateTaskUseCaseImplementation;
import com.hexagonal.spring_practice_hexagonal.application.usecases.DeleteTaskUseCaseImplementation;
import com.hexagonal.spring_practice_hexagonal.application.usecases.GetAdditionalTaskInfoUseCaseImplementation;
import com.hexagonal.spring_practice_hexagonal.application.usecases.RetrieveTaskUseCaseImplementation;
import com.hexagonal.spring_practice_hexagonal.application.usecases.UpdateTaskUseCaseImplementation;
import com.hexagonal.spring_practice_hexagonal.application.services.TaskService;

import com.hexagonal.spring_practice_hexagonal.domain.ports.in.GetAdditionalTaskInfoUseCase;
import com.hexagonal.spring_practice_hexagonal.domain.ports.out.ExternalServicePort;
import com.hexagonal.spring_practice_hexagonal.domain.ports.out.TaskRepositoryPort;
import com.hexagonal.spring_practice_hexagonal.infrastructure.adapters.ExternalServiceAdapter;
import com.hexagonal.spring_practice_hexagonal.infrastructure.repositories.JpaTaskRepositoryAdapter;


@Configuration
public class ApplicationConfig {
    @Bean
    public TaskService taskService(TaskRepositoryPort taskRepositoryPort, GetAdditionalTaskInfoUseCase getAdditionalTaskInfoUseCase) {
       return new TaskService(
            new CreateTaskUseCaseImplementation(taskRepositoryPort),
            new RetrieveTaskUseCaseImplementation(taskRepositoryPort),
            new UpdateTaskUseCaseImplementation(taskRepositoryPort),
            new DeleteTaskUseCaseImplementation(taskRepositoryPort),
            getAdditionalTaskInfoUseCase        
        );       
    }

    @Bean
    public TaskRepositoryPort taskRepositoryPort(JpaTaskRepositoryAdapter jpaTaskRepositoryAdapter){
        return jpaTaskRepositoryAdapter;
    }

    @Bean
    public GetAdditionalTaskInfoUseCase getAdditionalTaskInfoUseCase(ExternalServicePort externalServicePort){
        return new GetAdditionalTaskInfoUseCaseImplementation(externalServicePort);
    }

    @Bean
    public ExternalServicePort externalServicePort(){
        return new ExternalServiceAdapter();
    }
}
