package com.example.restfulwebservices2.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@ApiModel(description = "User details")
public class User {

    @ApiModelProperty(notes = "ID Should be unique")
    int id;

    @ApiModelProperty(notes = "Name must have at least 2 characters")
    @Size(min = 2)
    String name;

    @ApiModelProperty(notes = "Minimum age must be 18")
    @Min(18)
    int age;

    public User(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

}
