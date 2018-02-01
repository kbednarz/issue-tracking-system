package com.github.kbednarz.issuetrackingsystem.dto;

import com.github.kbednarz.issuetrackingsystem.domain.enums.Priority;
import com.github.kbednarz.issuetrackingsystem.domain.enums.Type;

import javax.validation.constraints.NotNull;

public class TaskDTO {
    @NotNull
    private String title;

    @NotNull
    private Type type;

    private String description;

    private Priority priority;

    private Long projectId;

    public TaskDTO(String title, Type type, String description, Priority priority, Long projectId) {
        this.title = title;
        this.type = type;
        this.description = description;
        this.priority = priority;
        this.projectId = projectId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

}

