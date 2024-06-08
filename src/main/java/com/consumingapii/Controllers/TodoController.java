package com.consumingapii.Controllers;

import com.consumingapii.Models.Todo;
import com.consumingapii.Service.TodoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;


/**
 * REST controller for managing todos.
 */
@RestController
@RequestMapping("/api/todos")
public class TodoController {
    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping
    public List<Todo> getAllTodos() {
        return todoService.fetchAllTodos();
    }

    @GetMapping("/{id}")
    public Todo getTodoById(@PathVariable Long id) {
        return todoService.fetchTodoById(id);
    }

    @GetMapping("/filter")
    public List<Todo> getIncompleteTodos() {
        return todoService.fetchAllTodos().stream()
                .filter(todo -> !todo.getCompleted())
                .collect(Collectors.toList());
    }
}

