package com.github.kbednarz.issuetrackingsystem.service;

import com.github.kbednarz.issuetrackingsystem.domain.Project;
import com.github.kbednarz.issuetrackingsystem.dto.ProjectDTO;
import com.github.kbednarz.issuetrackingsystem.observer.Observer;
import com.github.kbednarz.issuetrackingsystem.observer.Subject;
import com.github.kbednarz.issuetrackingsystem.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Service
public class ProjectService implements CrudServiceInterface<Project, ProjectDTO>, Subject {
    private List<Observer> observers = new LinkedList<>();

    @Autowired
    ProjectRepository projectRepository;

    @Override
    public Project save(ProjectDTO projectDTO) {
        Project project = new Project();
        project.setTitle(projectDTO.getTitle());
        project.setDescription(projectDTO.getDescription());

        project.setTimestamp(new Date());

        notifyObservers();

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
    public void addObserver(Observer obj) {
        observers.add(obj);
    }

    @Override
    public void removeObserver(Observer obj) {
        observers.remove(obj);
    }

    @Override
    public void notifyObservers() {
        observers.forEach(Observer::update);
    }
}
