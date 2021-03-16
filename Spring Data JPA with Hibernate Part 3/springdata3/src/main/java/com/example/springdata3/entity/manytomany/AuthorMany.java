package com.example.springdata3.entity.manytomany;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class AuthorMany {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "authors_books", joinColumns = @JoinColumn(name = "author_id", referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "book_id", referencedColumnName = "id"))
    private List<BookMany> books;

}
