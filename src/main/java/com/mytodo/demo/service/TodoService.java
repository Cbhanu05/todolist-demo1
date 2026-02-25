package com.mytodo.demo.service;

import com.mytodo.demo.entity.ToDo;
import com.mytodo.demo.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TodoService {

    private final TodoRepository repository;

    public List<ToDo> getAll() {
        return repository.findAll();
    }

    public ToDo create(ToDo todo) {
        return repository.save(todo);
    }

    public ToDo update(Long id, ToDo updatedTodo) {
        ToDo todo = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Todo not found"));

        todo.setTitle(updatedTodo.getTitle());
        todo.setCompleted(updatedTodo.isCompleted());

        return repository.save(todo);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}