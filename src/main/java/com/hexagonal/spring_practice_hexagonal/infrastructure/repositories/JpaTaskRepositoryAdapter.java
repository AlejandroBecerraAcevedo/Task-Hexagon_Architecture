package com.hexagonal.spring_practice_hexagonal.infrastructure.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.hexagonal.spring_practice_hexagonal.domain.models.Task;
import com.hexagonal.spring_practice_hexagonal.domain.ports.out.TaskRepositoryPort;
import com.hexagonal.spring_practice_hexagonal.infrastructure.entities.TaskEntity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data  // Genera automáticamente getters, setters, toString(), equals() y hashCode()
@AllArgsConstructor  // Genera un constructor con todos los atributos
@Component // Este inyección de dependencias es para que Spring pueda inyectar esta clase en otras clases
public class JpaTaskRepositoryAdapter implements TaskRepositoryPort{
    
    private final JpaTaskRepository jpaTaskRepository;
    
    @Override
    public boolean deleteById(Long id) {  
        if (jpaTaskRepository.existsById(id)) {
            jpaTaskRepository.deleteById(id);
            return true;
        }else{
            return false;
        }      
        
    }

    @Override
    public List<Task> findAll() {        
        return jpaTaskRepository.findAll()
                .stream()
                .map(TaskEntity::toDomainModel)
                .toList();
    }

    @Override
    public Optional<Task> findById(Long id) {        
        return jpaTaskRepository.findById(id).map(TaskEntity::toDomainModel);
    }

    @Override
    public Task save(Task task) {
        TaskEntity taskEntity = TaskEntity.fromDomainModel(task);
        TaskEntity savedTaskEntity = jpaTaskRepository.save(taskEntity);
        return savedTaskEntity.toDomainModel();       
    }

    @Override
    public Optional<Task> update(Task task) {  
   
        if (jpaTaskRepository.existsById(task.getId())) {
            TaskEntity taskEntity = TaskEntity.fromDomainModel(task);
            TaskEntity updatedTaskEntity = jpaTaskRepository.save(taskEntity);
            return Optional.of(updatedTaskEntity.toDomainModel());
        } else {
            return Optional.empty();
        }
    }
    
}
