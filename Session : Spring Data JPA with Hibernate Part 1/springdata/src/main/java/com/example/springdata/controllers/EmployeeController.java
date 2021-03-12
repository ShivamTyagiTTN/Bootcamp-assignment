package com.example.springdata.controllers;

import com.example.springdata.entities.Employee;
import com.example.springdata.exception.EmployeeNotFoundException;
import com.example.springdata.repos.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeRepository employeeRepository;

    //  Q.3 Perform Create Operation on Entity using Spring Data JPA
    @PostMapping("/employees")
    public void createEmployee(@RequestBody Employee employee) {
        employeeRepository.save(employee);
    }

    // Q.4 Perform Update Operation on Entity using Spring Data JPA
    @PutMapping("employees/{id}")
    public void updateEmployee(@RequestBody Employee newEmployee, @PathVariable int id) {
        Employee employee = employeeRepository.findById(id).orElse(null);

        if (employee != null) {
            employee.setName(newEmployee.getName());
            employee.setAge(newEmployee.getAge());
            employee.setLocation(newEmployee.getLocation());
            employeeRepository.save(employee);
        } else
            employeeRepository.save(newEmployee);
    }

    //  Q.5(2) Perform Delete Operation on Entity using Spring Data JPA
    @DeleteMapping("/employees/{id}")
    public void deleteById(@PathVariable int id) {
        if (employeeRepository.existsById(id))
            employeeRepository.deleteById(id);
    }

    // Q.5(1) Perform Read Operation on Entity using Spring Data JPA
    @GetMapping("employees/{id}")
    public Employee readEmployee(@PathVariable int id) {
        if (employeeRepository.existsById(id))
            return employeeRepository.findById(id).get();
        else
            throw new EmployeeNotFoundException("id - " + id);
    }

    // Q.6 Get the total count of the number of Employees
    @GetMapping("employees/count")
    public long count() {
        return employeeRepository.count();
    }

    // Q.7 Implement Pagination and Sorting on the bases of Employee Age
    @GetMapping("/employees/pageandsort")
    public Page<Employee> FindAllPageAndSortOnAge(){
        PageRequest sortedByAge = PageRequest.of(0, 2, Sort.Direction.DESC ,"age");
        return employeeRepository.findAll(sortedByAge);
    }

    //  Q.8 Create and use finder to find Employee by Name
    @GetMapping("employees/find/{name}")
    public List<Employee> findByName(@PathVariable String name) {
        return employeeRepository.findByName(name);
    }

    //  Q.9 Create and use finder to find Employees starting with A character.
    @GetMapping("employees/findbyA")
    public List<Employee> findByNameLike() {
        return employeeRepository.findByNameLike("A%");
    }

    //  Q.10 Create and use finder to find Employees Between the age of 28 to 32
    @GetMapping("employees/findbyage")
    public List<Employee> findByAgeBetween() {
        return employeeRepository.findByAgeBetween(18, 32);
    }
}
