package com.example.springdata3.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Subject {

    @Id
    private int id;

    private int authorId;

    private String subjectName;

    @JoinColumn(name = "author_id")
    @ManyToOne
    private Author author;
}
