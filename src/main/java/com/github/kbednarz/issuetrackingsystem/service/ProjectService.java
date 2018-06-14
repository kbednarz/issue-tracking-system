package com.github.kbednarz.issuetrackingsystem.service;

import com.github.kbednarz.issuetrackingsystem.controller.AddController.IProjectable;
import com.github.kbednarz.issuetrackingsystem.controller.AddController.IUser;
import com.github.kbednarz.issuetrackingsystem.domain.Project;
import com.github.kbednarz.issuetrackingsystem.dto.ProjectDTO;
import com.github.kbednarz.issuetrackingsystem.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ProjectService implements CrudServiceInterface<Project, ProjectDTO>, IProjectable {

    @Autowired

    ProjectRepository projectRepository;

    @Override
    public Project save(ProjectDTO projectDTO) {
        Project project = new Project();
        project.setTitle(projectDTO.getTitle());
        project.setDescription(projectDTO.getDescription());

        project.setTimestamp(new Date());

        return projectRepository.save(project);
    }

    @Override
    public Project get(Long id) {
        return projectRepository.findOne(id);
    }

    @Override
    public List<Project> listAll() {
        return (List<Project>) projectRepository.findAll();
    }

    @Override
    public void add(IUser o) {
        //jak?
    }

    @Override
    public void remove(IUser o) {
        //jak?
    }

    @Override
    public void Notify() {

    }

    public void addTask(){};
}
