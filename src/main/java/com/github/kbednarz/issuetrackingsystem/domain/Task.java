package com.github.kbednarz.issuetrackingsystem.domain;

import com.github.kbednarz.issuetrackingsystem.domain.enums.Priority;
import com.github.kbednarz.issuetrackingsystem.domain.enums.Status;
import com.github.kbednarz.issuetrackingsystem.domain.enums.Type;
import org.springframework.security.core.userdetails.User;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Task {
    @Id
    private long id;

    private String title;

    private Status status;

    private Type type;

    private Date dueDate;

    private Date timestamp;

    private Date lastUpdate;

    private User reporter;

    private User assignee;

    private String description;

    private Priority priority;
}
