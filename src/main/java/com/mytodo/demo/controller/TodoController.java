package com.mytodo.demo.controller;

import com.mytodo.demo.entity.ToDo;
import com.mytodo.demo.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todos")
@RequiredArgsConstructor
public class TodoController {

    private final TodoService service;

    @GetMapping
    public List<ToDo> getAll() {
        return service.getAll();
    }

    @PostMapping
    public ToDo create(@RequestBody ToDo todo) {
        return service.create(todo);
    }

    @PutMapping("/{id}")
    public ToDo update(@PathVariable Long id, @RequestBody ToDo todo) {
        return service.update(id, todo);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}