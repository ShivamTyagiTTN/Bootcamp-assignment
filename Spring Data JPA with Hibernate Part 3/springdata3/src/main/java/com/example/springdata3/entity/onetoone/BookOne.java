package com.example.springdata3.entity.onetoone;

import lombok.Data;
import org.springframework.data.annotation.Id;

import javax.persistence.*;

@Entity
@Data
public class BookOne {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String bookName;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "author_id")
    private AuthorOne authorOne;
}
