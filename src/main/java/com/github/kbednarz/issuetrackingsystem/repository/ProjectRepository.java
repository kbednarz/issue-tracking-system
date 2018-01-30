package com.github.kbednarz.issuetrackingsystem.repository;

import com.github.kbednarz.issuetrackingsystem.domain.Project;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends CrudRepository<Project, Long> {
}
