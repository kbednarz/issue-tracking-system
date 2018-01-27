package com.github.kbednarz.issuetrackingsystem.service;

import com.github.kbednarz.issuetrackingsystem.domain.Task;
import com.github.kbednarz.issuetrackingsystem.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService implements CrudServiceInterface<Task> {
    @Autowired
    TaskRepository taskRepository;

    public Task save(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public Task get(Long id) {
        return taskRepository.findOne(id);
    }

    @Override
    public List<Task> listAll() {
        return (List<Task>) taskRepository.findAll();
    }
}
