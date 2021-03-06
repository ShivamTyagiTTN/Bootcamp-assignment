/*
    Q.2 Create an Employee Bean(id, name, age) and service to  perform different operations related to employee.
*/

package com.ttn.restfulwebservices.q2to9;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

public class Employee {

    private int id;

    @Size(min = 2, message = "Name must have at least 2 characters")
    private String name;

    @Min(value = 18, message = "Employee must be an adult")
    private int age;

    public Employee(int id, String name, int age) {
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
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
