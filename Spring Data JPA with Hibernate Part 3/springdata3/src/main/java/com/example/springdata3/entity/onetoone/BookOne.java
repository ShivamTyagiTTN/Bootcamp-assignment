package com.example.springdata3.entity.onetoone;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "book")
@Data
public class BookOne {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String bookName;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "author_id")
    private AuthorOne authorOne;
}
