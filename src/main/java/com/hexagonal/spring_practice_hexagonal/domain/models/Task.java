package com.hexagonal.spring_practice_hexagonal.domain.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;



@Data  // Genera automáticamente getters, setters, toString(), equals() y hashCode()
@AllArgsConstructor  // Genera un constructor con todos los atributos
@NoArgsConstructor  // Genera un constructor vacío
@Builder // permite generar un patrón de diseño Builder para una clase de manera automática.
public class Task {
    private Long id;
    private String title;
    private String description;
    private LocalDateTime createdDate;
    private boolean completed;
}
