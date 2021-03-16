package com.example.springdata3.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Author {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;
    private String name;

    @Embedded
    private Address address;

    @OneToMany(mappedBy = "author", cascade = CascadeType.PERSIST)
    private List<Subject> subjectList;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    private List<Book> books;

}
