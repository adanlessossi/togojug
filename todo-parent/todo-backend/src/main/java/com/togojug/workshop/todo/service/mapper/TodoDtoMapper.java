package com.togojug.workshop.todo.service.mapper;

import com.togojug.workshop.todo.api.TodoDto;
import com.togojug.workshop.todo.domain.Todo;

import java.util.List;
import java.util.stream.Collectors;

public class TodoDtoMapper {

    private TodoDtoMapper(){
        // Hide the constructor
    }

    public static Todo map(TodoDto dto){
        return Todo.builder()
                .id(dto.getId())
                .assignee(dto.getAssignee())
                .description(dto.getDescription())
                .targetDate(dto.getTargetDate())
                .isDone(dto.isDone())
                .build();
    }

    public static List<TodoDto> mapTodos(List<Todo> todos){
        return todos.stream()
                .map(TodoDtoMapper::map)
                .collect(Collectors.toList());
    }

    public static List<Todo> mapTodoDtos(List<TodoDto> todoDtos){
        return todoDtos.stream()
                .map(TodoDtoMapper::map)
                .collect(Collectors.toList());
    }

    public static TodoDto map(Todo todo){
        return TodoDto.builder()
                .id(todo.getId())
                .assignee(todo.getAssignee())
                .description(todo.getDescription())
                .targetDate(todo.getTargetDate())
                .isDone(todo.isDone())
                .build();
    }
}
