package com.example.restfulwebservices2.versioning;

public class StudentV2 {

    private Name name;

    public StudentV2(Name name) {
        this.name = name;
    }

    public Name getStudent() {
        return name;
    }
}
