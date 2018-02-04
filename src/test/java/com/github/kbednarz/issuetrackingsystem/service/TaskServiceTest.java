package com.github.kbednarz.issuetrackingsystem.service;

import com.github.kbednarz.issuetrackingsystem.domain.Task;
import com.github.kbednarz.issuetrackingsystem.dto.TaskDTO;
import com.github.kbednarz.issuetrackingsystem.repository.TaskRepository;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class TaskServiceTest {
    private TaskService taskService;
    private TaskRepository taskRepository;
    private ProjectService projectService;

    @Before
    public void setUp() throws Exception {
        taskService = new TaskService();
        
        taskRepository = mock(TaskRepository.class);
        taskService.taskRepository = taskRepository;

        projectService = mock(ProjectService.class);
        taskService.projectService = projectService;
    }

    @Test
    public void save() {
        // given
        TaskDTO taskDTO = mock(TaskDTO.class);

        //when
        taskService.save(taskDTO);

        //then
        verify(taskRepository).save(any(Task.class));
    }

    @Test
    public void get() {
        long id = 123;
        //when
        taskService.get(id);

        //then
        verify(taskRepository).findOne(id);
    }

    @Test
    public void listAll() {
        //when
        taskService.listAll();

        //then
        verify(taskRepository).findAll();
    }
}