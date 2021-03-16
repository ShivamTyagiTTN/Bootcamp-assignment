package com.example.springdata3.entity.onetoone;

import com.example.springdata3.entity.Address;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "author")
@Data
public class AuthorOne {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @OneToOne(mappedBy = "authorOne", cascade = CascadeType.ALL)
    private BookOne BookOne;

}
