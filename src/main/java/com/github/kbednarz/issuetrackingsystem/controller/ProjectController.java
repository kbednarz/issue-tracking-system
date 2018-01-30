package com.github.kbednarz.issuetrackingsystem.controller;

import com.github.kbednarz.issuetrackingsystem.domain.Project;
import com.github.kbednarz.issuetrackingsystem.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/project")
public class ProjectController {

    @Autowired
    ProjectService projectService;

    @GetMapping
    public Project getProject(@RequestParam Long id) {
        return projectService.get(id);
    }

    @PostMapping
    public Project saveProject(@RequestBody Project project) {
        return projectService.save(project);
    }

    @GetMapping("list")
    public List<Project> listProjects() {
        return projectService.listAll();
    }

}
