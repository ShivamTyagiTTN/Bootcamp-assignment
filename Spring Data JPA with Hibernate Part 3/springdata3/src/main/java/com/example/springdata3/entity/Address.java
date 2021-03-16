package com.example.springdata3.entity;

import lombok.Data;

import javax.persistence.*;

@Embeddable
@Data
public class Address {

    private int id;

    private int authorId;

    private String streetNumber;

    private String location;

    private String state;

}
