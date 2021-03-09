package com.example.restfulwebservices2.filtering;

import com.fasterxml.jackson.annotation.JsonFilter;

@JsonFilter("employeeFilter") // comment for static filtering
public class Employee {

    private String name;

/*  Q.8. static filtering, (commented to demonstrate dynamic filtering)*/

    //@JsonIgnore
    private String password;

    public Employee(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
