package com.hexagonal.spring_practice_hexagonal.infrastructure.entities;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.hexagonal.spring_practice_hexagonal.domain.models.Task;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data  // Genera automáticamente getters, setters, toString(), equals() y hashCode()
@AllArgsConstructor  // Genera un constructor con todos los atributos
@NoArgsConstructor  // Genera un constructor vacío
@Builder // permite generar un patrón de diseño Builder para una clase de manera automática.
@Entity // Indica que esta clase es una entidad de la base de datos
@Table(name = "tasks")
public class TaskEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonProperty("title")
    private String title;

    @JsonProperty("description")
    private String description;

    @JsonProperty("createdDate")
    private LocalDateTime createdDate;

    @JsonProperty("completed")
    private boolean completed;

    public static TaskEntity fromDomainModel(Task task) {
        return TaskEntity.builder()
                .id(task.getId())
                .title(task.getTitle())
                .description(task.getDescription())
                .createdDate(task.getCreatedDate())
                .completed(task.isCompleted())
                .build(); // Crea una instancia de TaskEntity con los atributos de la tarea
    }

    public Task toDomainModel() {
        return Task.builder()
                .id(this.id)
                .title(this.title)
                .description(this.description)
                .createdDate(this.createdDate)
                .completed(this.completed)
                .build(); // Crea una instancia de Task con los atributos de la entidad
    }
}