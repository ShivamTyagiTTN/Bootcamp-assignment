package com.assignment.springdata2.service;

import com.assignment.springdata2.repos.JpqlEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class JpqlEmployeeService {

    @Autowired
    JpqlEmployeeRepository jpqlEmployeeRepository;

 /* Q.1 Display the first name, last name of all employees having salary greater than average salary ordered
       in ascending by their age and in descending by their salary.*/
    public void findAllBelowAvg() {
        List<Object[]> list = jpqlEmployeeRepository.findAllEmployee(Sort.by
                (new Sort.Order(Sort.Direction.ASC, "age"),
                        new Sort.Order(Sort.Direction.DESC, "salary")));
        list.forEach(emp -> System.out.println(emp[0] + " " + emp[1]));
    }


    /*  Q.2 Update salary of all employees by a salary passed as a parameter
            whose existing salary is less than the average salary.*/
    @Transactional
    public void updateBelowAvgEmpSalary(int salary) {
        int avgSalary = jpqlEmployeeRepository.findAverageSalary();
        jpqlEmployeeRepository.updateBelowAvgEmpSalary(salary, avgSalary);
    }

    //  Q.3 Delete all employees with minimum salary.
    @Transactional
    public void deleteEmployeeMinSalary() {
        int minSalary = jpqlEmployeeRepository.findMinSalary();
        jpqlEmployeeRepository.deleteEmployeeMinSalary(minSalary);
    }

    //  Q.4 Display the id, first name, age of all employees where last name ends with "singh"
    public void getAllEmployeeNameEndsWith() {
        List<Object[]> singhNames = jpqlEmployeeRepository.getAllEmployeeNameEndsWith();
        for (Object[] objects : singhNames) {
            System.out.println("Id = " + objects[0] + ", First Name = " + objects[1] + ", Age = " + objects[2]);
        }
    }

    // Q.5 Delete all employees with age greater than 45(Should be passed as a parameter)
    @Transactional
    public void deleteEmployeeAgeGreaterThan(int age) {
        jpqlEmployeeRepository.deleteEmployeeAgeGreaterThan(age);
    }

}
