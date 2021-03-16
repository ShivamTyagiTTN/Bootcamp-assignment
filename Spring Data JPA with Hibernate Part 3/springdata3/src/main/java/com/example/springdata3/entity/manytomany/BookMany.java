package com.example.springdata3.entity.manytomany;

import lombok.Data;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "book_many")
@Data
public class BookMany {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String bookName;

    @ManyToMany(mappedBy = "books")
    private List<AuthorMany> authors;

}
