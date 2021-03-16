package com.example.springdata3.entity;

import lombok.Data;

import javax.persistence.*;

@Embeddable
@Data
public class Address {

    private String streetNumber;

    private String location;

    private String state;

}
