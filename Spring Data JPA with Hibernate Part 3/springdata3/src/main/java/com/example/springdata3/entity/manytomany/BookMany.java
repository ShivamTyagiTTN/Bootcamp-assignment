package com.example.springdata3.entity.manytomany;

import lombok.Data;
import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class BookMany {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String bookName;

    @ManyToMany(mappedBy = "books")
    private List<AuthorMany> authors;

}
