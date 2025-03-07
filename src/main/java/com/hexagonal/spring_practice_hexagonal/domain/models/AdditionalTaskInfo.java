package com.hexagonal.spring_practice_hexagonal.domain.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data  // Genera automáticamente getters, setters, toString(), equals() y hashCode()
@AllArgsConstructor  // Genera un constructor con todos los atributos
public class AdditionalTaskInfo {

    private Long userId;
    private final String userName;
    private final String userEmail;    
}
