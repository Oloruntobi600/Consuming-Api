package com.consumingapii.Service;

import com.consumingapii.Models.Todo;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * Service layer for handling todo-related operations.
 */
@Service
public class TodoService {
    private final RestTemplate restTemplate;
    private final String BASE_URL = "https://jsonplaceholder.typicode.com/todos";

    public TodoService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public List<Todo> fetchAllTodos() {
        return Arrays.asList(Objects.requireNonNull(restTemplate.getForObject(BASE_URL, Todo[].class)));
    }

    public Todo fetchTodoById(Long id) {
        return restTemplate.getForObject(BASE_URL + "/" + id, Todo.class);
    }
}
