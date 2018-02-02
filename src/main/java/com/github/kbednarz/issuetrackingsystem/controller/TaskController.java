package com.github.kbednarz.issuetrackingsystem.controller;

import com.github.kbednarz.issuetrackingsystem.domain.Task;
import com.github.kbednarz.issuetrackingsystem.dto.TaskDTO;
import com.github.kbednarz.issuetrackingsystem.repository.TaskRepository;
import com.github.kbednarz.issuetrackingsystem.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api/task")
public class TaskController {
    @Autowired
    TaskRepository taskRepository;

    @Autowired
    TaskService taskService;

    @GetMapping
    public Task getTask(@RequestParam Long id) {
        return taskRepository.findOne(id);
    }

    @PostMapping
    public Task save(@RequestBody @Valid TaskDTO taskDTO) {
        return taskService.save(taskDTO);
    }
}
