package com.consumingapii.Service;

import com.consumingapii.Models.Todo;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TodoServiceTest {
    @Autowired
    private TodoService todoService;

    @MockBean
    private RestTemplate restTemplate;

    @Test
    void testFetchAllTodos() {
        Todo[] todos = { new Todo(), new Todo() };
        Mockito.when(restTemplate.getForObject(Mockito.anyString(), Mockito.eq(Todo[].class)))
                .thenReturn(todos);

        List<Todo> result = todoService.fetchAllTodos();
        assertEquals(2, result.size());
    }

    @Test
    void testFetchTodoById() {
        Todo todo = new Todo();
        todo.setId(1L);
        Mockito.when(restTemplate.getForObject(Mockito.anyString(), Mockito.eq(Todo.class)))
                .thenReturn(todo);

        Todo result = todoService.fetchTodoById(1L);
        assertEquals(1L, result.getId());
    }
}
