package com.github.kbednarz.issuetrackingsystem.domain;

import com.github.kbednarz.issuetrackingsystem.domain.auth.User;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;

    @JoinColumn
    @OneToOne
    private User owner;

    private String description;

    private Date timestamp;

    @OneToMany(mappedBy = "project")
    private List<Task> tasks = new ArrayList<>();
}
