package com.mytodo.demo.service;

import com.mytodo.demo.dto.TodoRequestDTO;
import com.mytodo.demo.dto.TodoResponseDTO;
import com.mytodo.demo.entity.ToDo;
import com.mytodo.demo.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TodoService {

    private final TodoRepository repository;

    public List<TodoResponseDTO> getAll() {
        return repository.findAll()
                .stream()
                .map(todo -> new TodoResponseDTO(
                        todo.getId(),
                        todo.getTitle(),
                        todo.isCompleted()
                ))
                .collect(Collectors.toList());
    }

    public TodoResponseDTO save(TodoRequestDTO request) {

        ToDo todo = new ToDo();
        todo.setTitle(request.getTitle());
        todo.setCompleted(request.isCompleted());

        ToDo saved = repository.save(todo);

        return new TodoResponseDTO(
                saved.getId(),
                saved.getTitle(),
                saved.isCompleted()
        );
    }

    public TodoResponseDTO update(Long id, TodoRequestDTO request) {

        ToDo existing = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Todo not found"));

        existing.setTitle(request.getTitle());
        existing.setCompleted(request.isCompleted());

        ToDo updated = repository.save(existing);

        return new TodoResponseDTO(
                updated.getId(),
                updated.getTitle(),
                updated.isCompleted()
        );
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}