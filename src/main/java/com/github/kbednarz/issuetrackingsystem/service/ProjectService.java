package com.github.kbednarz.issuetrackingsystem.service;

import com.github.kbednarz.issuetrackingsystem.domain.Project;
import com.github.kbednarz.issuetrackingsystem.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ProjectService implements CrudServiceInterface<Project> {

    @Autowired
    ProjectRepository projectRepository;

    @Override
    public Project save(Project instance) {
        instance.setTimestamp(new Date());

        return projectRepository.save(instance);
    }

    @Override
    public Project get(Long id) {
        return projectRepository.findOne(id);
    }

    @Override
    public List<Project> listAll() {
        return (List<Project>) projectRepository.findAll();
    }
}
