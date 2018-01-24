package com.github.kbednarz.issuetrackingsystem.domain;

import javax.persistence.*;

@Entity
public class Attachment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String filename;

    @Lob
    private byte[] content;

    @ManyToOne
    @JoinColumn
    private Task task;
}
