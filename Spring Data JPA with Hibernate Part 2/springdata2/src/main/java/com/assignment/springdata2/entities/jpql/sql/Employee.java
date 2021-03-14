package com.assignment.springdata2.entities.jpql.sql;

import com.assignment.springdata2.entities.component.mapping.Salary;

import javax.persistence.*;

@Entity
@Table
public class Employee {

    @Column(name = "empid")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int empId;
    @Column(name = "empfirstname")
    String firstName;
    @Column(name = "emplastname")
    String lastName;
    @Column(name = "empsalary")
    int salary;
    @Column(name = "empage")
    int age;

    public Employee() {
    }

    public Employee(String firstName, String lastName, int salary, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.age = age;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}
