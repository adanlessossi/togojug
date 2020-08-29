package com.togojug.workshop.todo.service;

import com.togojug.workshop.todo.api.TodoDto;
import com.togojug.workshop.todo.domain.Todo;
import com.togojug.workshop.todo.domain.TodoRepository;
import com.togojug.workshop.todo.service.mapper.TodoDtoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class TodoServiceDefinition implements TodoService {

    private TodoRepository repository;

    @Autowired
    public TodoServiceDefinition(TodoRepository repository){
        this.repository = repository;
    }

    @Override
    public List<TodoDto> getAllTodos() {
        List<Todo> allTodos = this.repository.findAll();
        return TodoDtoMapper.mapTodos(allTodos);
    }

    @Override
    public TodoDto getById(UUID id) {
        Todo todo = this.getTodoById(id);
        return TodoDtoMapper.map(todo);
    }

    @Override
    public TodoDto create(TodoDto todoDto) {
        Todo toSave = TodoDtoMapper.map(todoDto);
        Todo created =  this.repository.save(toSave);
        return TodoDtoMapper.map(created);
    }

    @Override
    public TodoDto update(UUID id, TodoDto todoDto) {
        Todo todo = TodoDtoMapper.map(todoDto);

        TodoDto existing = getById(id);
        Todo toUpdate = TodoDtoMapper.map(existing);
        toUpdate.setAssignee(todo.getAssignee());
        toUpdate.setDescription(todo.getDescription());
        toUpdate.setTargetDate(todo.getTargetDate());
        toUpdate.setDone(todo.isDone());

        Todo updated = this.repository.save(toUpdate);
        return TodoDtoMapper.map(updated);
    }

    @Override
    public void delete(UUID id) {
        boolean exists = this.repository.existsById(id);
        if (exists){
            Todo todo = this.repository.getOne(id);
            this.repository.delete(todo);
        }
    }

    @Override
    public List<TodoDto> getTodoByAssignee(String assignee) {
        List<Todo> assigneeTodos = this.repository.findAllByAssignee(assignee);
        return TodoDtoMapper.mapTodos(assigneeTodos);
    }

    private Todo getTodoById(UUID id){
        return this.repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Todo id not found!"));
    }
}
