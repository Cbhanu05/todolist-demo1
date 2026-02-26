package com.mytodo.demo.dto;

public class TodoResponseDTO {

    private Long id;
    private String title;
    private boolean completed;

    public TodoResponseDTO(Long id, String title, boolean completed) {
        this.id = id;
        this.title = title;
        this.completed = completed;
    }

    // getters only (immutable response)
    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public boolean isCompleted() {
        return completed;
    }
}