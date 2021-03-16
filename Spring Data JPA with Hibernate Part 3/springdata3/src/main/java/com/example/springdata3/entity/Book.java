package com.example.springdata3.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String bookName;

    @JoinColumn(name = "author_id")
    @ManyToOne
    private Author author;
}
