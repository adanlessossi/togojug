package com.togojug.workshop.todo.service;

import com.togojug.workshop.todo.api.TodoDto;
import com.togojug.workshop.todo.domain.Todo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

public interface TodoService {

    List<TodoDto> getAllTodos();
    TodoDto getById(UUID id);
    TodoDto create(TodoDto todoDto);
    TodoDto update(UUID id, TodoDto todoDto);
    void delete(UUID id);
    List<TodoDto> getTodoByAssignee(String assignee);
}
