package com.github.kbednarz.issuetrackingsystem.service;

import com.github.kbednarz.issuetrackingsystem.domain.Task;
import com.github.kbednarz.issuetrackingsystem.domain.enums.Priority;
import com.github.kbednarz.issuetrackingsystem.domain.enums.Status;
import com.github.kbednarz.issuetrackingsystem.domain.enums.Type;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.User;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

import static org.junit.Assert.assertNotNull;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TaskServiceIntTest {
    @Autowired
    private TaskService taskService;

    @Test
    public void save() {
        // given
//        User user = new User();

        Task task = new Task();
        task.setTitle("Task title");
        task.setStatus(Status.TODO);
        task.setType(Type.TASK);
        task.setTimestamp(new Date());
        task.setLastUpdate(new Date());
//        task.setReporter(user);
        task.setPriority(Priority.NORMAL);


        // when
        Task result = taskService.save(task);

        // then
        assertNotNull(result);
    }
}