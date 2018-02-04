package com.github.kbednarz.issuetrackingsystem.domain;

import com.github.kbednarz.issuetrackingsystem.domain.auth.User;
import com.github.kbednarz.issuetrackingsystem.domain.enums.Status;
import com.github.kbednarz.issuetrackingsystem.domain.enums.Type;

import java.util.ArrayList;
import java.util.List;

public class TaskBulkChangeComposite extends Task {
    private List<Task> tasks = new ArrayList<>();

    public void add(Task task) {
        tasks.add(task);
    }

    public void remove(Task task) {
        for (Task obj : tasks) {
            if (obj.getId() == task.getId())
                tasks.remove(obj);
        }
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setStatus(Status status) {
        for (Task task : tasks) {
            task.setStatus(status);
        }
    }

    public void setType(Type type) {
        for (Task task : tasks) {
            task.setType(type);
        }
    }

    public void setAssignee(User assignee) {
        for (Task task : tasks) {
            task.setAssignee(assignee);
        }
    }
}
