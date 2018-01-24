package com.github.kbednarz.issuetrackingsystem.domain;

import com.github.kbednarz.issuetrackingsystem.domain.auth.User;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    @JoinColumn
    private User writer;

    private Date timestamp;

    private String content;

    @ManyToOne
    @JoinColumn
    private Task task;
}
