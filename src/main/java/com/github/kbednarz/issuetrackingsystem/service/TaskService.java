package com.github.kbednarz.issuetrackingsystem.service;

import com.github.kbednarz.issuetrackingsystem.domain.Project;
import com.github.kbednarz.issuetrackingsystem.domain.Task;
import com.github.kbednarz.issuetrackingsystem.domain.enums.Priority;
import com.github.kbednarz.issuetrackingsystem.domain.enums.Status;
import com.github.kbednarz.issuetrackingsystem.dto.TaskDTO;
import com.github.kbednarz.issuetrackingsystem.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TaskService implements CrudServiceInterface<Task, TaskDTO> {
    @Autowired
    TaskRepository taskRepository;

    @Autowired
    ProjectService projectService;

    public Task save(TaskDTO taskDTO) {
        Task task = new Task();
        task.setTitle(taskDTO.getTitle());
        task.setType(taskDTO.getType());
        task.setStatus(Status.TODO);
        task.setTimestamp(new Date());
        task.setLastUpdate(new Date());

        if (taskDTO.getPriority() != null) {
            task.setPriority(taskDTO.getPriority());
        } else {
            task.setPriority(Priority.NORMAL);
        }

        task.setDescription(taskDTO.getDescription());

        Project project = projectService.get(taskDTO.getProjectId());
        task.setProject(project);

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
