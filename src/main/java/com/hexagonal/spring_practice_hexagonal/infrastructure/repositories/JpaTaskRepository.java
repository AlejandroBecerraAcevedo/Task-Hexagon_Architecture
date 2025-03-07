package com.hexagonal.spring_practice_hexagonal.infrastructure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hexagonal.spring_practice_hexagonal.infrastructure.entities.TaskEntity;


@Repository // Esta anotación es para que Spring pueda escanear esta interfaz y crear un bean de esta interfaz
public interface JpaTaskRepository extends JpaRepository<TaskEntity, Long> { // es una interfaz que extiende de JpaRepository, que es una interfaz de Spring Data JPA que proporciona métodos CRUD para la entidad TaskEntity
  
}
