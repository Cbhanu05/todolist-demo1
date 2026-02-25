package com.mytodo.demo.repository;

import com.mytodo.demo.entity.ToDo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<ToDo, Long> {
}