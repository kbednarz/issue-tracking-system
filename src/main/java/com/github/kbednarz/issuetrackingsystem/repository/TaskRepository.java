package com.github.kbednarz.issuetrackingsystem.repository;

import com.github.kbednarz.issuetrackingsystem.domain.Task;
import org.springframework.data.repository.CrudRepository;

public interface TaskRepository extends CrudRepository<Task, Long> {

}
