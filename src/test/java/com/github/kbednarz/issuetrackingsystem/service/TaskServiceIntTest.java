package com.github.kbednarz.issuetrackingsystem.service;

import com.github.kbednarz.issuetrackingsystem.domain.Task;
import com.github.kbednarz.issuetrackingsystem.domain.auth.User;
import com.github.kbednarz.issuetrackingsystem.domain.enums.Priority;
import com.github.kbednarz.issuetrackingsystem.domain.enums.Status;
import com.github.kbednarz.issuetrackingsystem.domain.enums.Type;
import com.github.kbednarz.issuetrackingsystem.dto.TaskDTO;
import com.github.kbednarz.issuetrackingsystem.repository.TaskRepository;
import com.github.kbednarz.issuetrackingsystem.repository.auth.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TaskServiceIntTest {

    @Autowired
    private TaskService taskService;

    @Autowired
    UserRepository userRepository;

    @Autowired
    TaskRepository taskRepository;

    @Test
    public void save() {
        // given
        assertEquals(0, taskRepository.count());

        TaskDTO taskDTO = new TaskDTO("Task title", Type.TASK, null,Priority.NORMAL,12L);

        // when
        Task result = taskService.save(taskDTO);

        // then
        assertEquals(1, taskRepository.count());
        assertNotNull(result);
    }

    private User createUser() {
        User user = new User();
        user.setUsername("testUser");
        user.setPassword("pass");

        return userRepository.save(user);
    }
}