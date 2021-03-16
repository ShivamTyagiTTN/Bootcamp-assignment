package com.example.springdata3.entity.manytomany;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "author_many")
@Data
public class AuthorMany {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String authorName;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "authors_books", joinColumns = @JoinColumn(name = "author_id", referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "book_id", referencedColumnName = "id"))
    private List<BookMany> books;

}
