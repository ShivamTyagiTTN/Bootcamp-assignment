package com.example.springdata3.entity.onetoone;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class AuthorOne {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;

    @OneToMany(mappedBy = "author_one")
    private BookOne BookOne;

}
