package com.togojug.workshop.todo.controller;

import com.togojug.workshop.todo.api.TodoDto;
import com.togojug.workshop.todo.service.TodoService;
import com.togojug.workshop.todo.service.TodoServiceDefinition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/todo")
public class TodoController {

    private TodoServiceDefinition todoService;

    @Autowired
    public TodoController(TodoServiceDefinition todoService){
        this.todoService = todoService;
    }

    @GetMapping("/")
    public List<TodoDto> getAllTodos() {
        return todoService.getAllTodos();
    }

    @DeleteMapping("/{id}")
    public void deleteTodo(@PathVariable UUID id) {
        this.todoService.delete(id);
    }

    @GetMapping("/{id}")
    public TodoDto getById(@PathVariable String username, @PathVariable UUID id) {
        return todoService.getById(id);
    }

    @PutMapping("/{id}")
    public TodoDto updateTodo(@PathVariable UUID id,
                              @RequestBody TodoDto todoDto) {
        return this.todoService.update(id, todoDto);
    }

    @PostMapping("/")
    public TodoDto createTodo(@RequestBody TodoDto todoDto) {
        //log.info("Creating a new todo");
        return this.todoService.create(todoDto);
    }
}
