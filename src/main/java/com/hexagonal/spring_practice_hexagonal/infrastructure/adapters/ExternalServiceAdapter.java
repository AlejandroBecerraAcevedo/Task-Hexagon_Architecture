package com.hexagonal.spring_practice_hexagonal.infrastructure.adapters;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.hexagonal.spring_practice_hexagonal.domain.models.AdditionalTaskInfo;
import com.hexagonal.spring_practice_hexagonal.domain.ports.out.ExternalServicePort;


import lombok.Data;

@Component
public class ExternalServiceAdapter implements ExternalServicePort {

    private final RestTemplate restTemplate;

    public ExternalServiceAdapter() {
        restTemplate = new RestTemplate();
    }

    @Override
    public AdditionalTaskInfo getAdditionalTaskInfo(Long taskId) {
        // Aquí se simula una llamada a un servicio externo
        String url = "https://jsonplaceholder.typicode.com/todos/" + taskId;
        ResponseEntity<JsonPlaceholderTodo> response = restTemplate.getForEntity(url, JsonPlaceholderTodo.class);
        JsonPlaceholderTodo todo = response.getBody();

        if(todo == null){
            return null;
        }

        url = "https://jsonplaceholder.typicode.com/users/" + todo.getUserId();
        ResponseEntity<JsonPlaceholderUser> userResponse = restTemplate.getForEntity(url, JsonPlaceholderUser.class);
        JsonPlaceholderUser user = userResponse.getBody();
        
        if(user == null){
            return null;
        }

        return new AdditionalTaskInfo(user.getId(), user.getName(), user.getEmail());

    }
    
    @Data  // Genera automáticamente getters, setters, toString(), equals() y hashCode()
    private static class JsonPlaceholderTodo {
        private Long Id;
        private Long userId;
    }    

    @Data  // Genera automáticamente getters, setters, toString(), equals() y hashCode()
    private static class JsonPlaceholderUser{
        private Long id;
        private String name;
        private String email;
    }
}
