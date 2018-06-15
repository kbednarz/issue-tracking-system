package com.github.kbednarz.issuetrackingsystem.controller;

import com.github.kbednarz.issuetrackingsystem.controller.AddController.IProjectable;
import com.github.kbednarz.issuetrackingsystem.controller.AddController.IUser;
import com.github.kbednarz.issuetrackingsystem.domain.Project;
import com.github.kbednarz.issuetrackingsystem.dto.ProjectDTO;
import com.github.kbednarz.issuetrackingsystem.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    public Project saveProject(@RequestBody @Valid ProjectDTO projectDTO) {
        return projectService.save(projectDTO);
    }

    @GetMapping("list")
    public List<Project> listProjects() {
        return projectService.listAll();
    }

}
