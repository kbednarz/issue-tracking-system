package com.github.kbednarz.issuetrackingsystem.service;

import com.github.kbednarz.issuetrackingsystem.domain.Task;
import com.github.kbednarz.issuetrackingsystem.repository.TaskRepository;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class TaskServiceTest {
    TaskService taskService;
    TaskRepository taskRepository;

    @Before
    public void setUp() throws Exception {
        taskService = new TaskService();
        taskRepository = mock(TaskRepository.class);
        taskService.taskRepository = taskRepository;
    }

    @Test
    public void save() {
        // given
        Task task = mock(Task.class);

        //when
        taskService.save(task);

        //then
        verify(taskRepository).save(task);
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