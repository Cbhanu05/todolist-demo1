package com.mytodo.demo.controller;

import com.mytodo.demo.dto.TodoRequestDTO;
import com.mytodo.demo.dto.TodoResponseDTO;
import com.mytodo.demo.service.TodoService;
import lombok.RequiredArgsConstructor;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todos")
@RequiredArgsConstructor
public class TodoController {

    private final TodoService service;

    @GetMapping
    public List<TodoResponseDTO> getAll() {
        return service.getAll();
    }

    @PostMapping
    public TodoResponseDTO createTodo(
            @Valid @RequestBody TodoRequestDTO request) {
        return service.save(request);
    }

    @PutMapping("/{id}")
    public TodoResponseDTO update(
            @PathVariable Long id,
            @Valid @RequestBody TodoRequestDTO request) {
        return service.update(id, request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}