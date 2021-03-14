package com.assignment.springdata2.service;

import com.assignment.springdata2.entities.component.mapping.EmployeeNew;
import com.assignment.springdata2.entities.component.mapping.Salary;
import com.assignment.springdata2.repos.ComponentMappingEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ComponentMappingService {

    @Autowired
    ComponentMappingEmployeeRepository componentMappingEmployeeRepository;

    public void createComponentMappedEmployee(){
        EmployeeNew employeeNew = new EmployeeNew();
        employeeNew.setId(101);
        employeeNew.setFirstName("Ankit");
        employeeNew.setLastName("Sharma");
        employeeNew.setAge(25);

        Salary salary = new Salary();
        salary.setBasicSalary(25000.0);
        salary.setBonusSalary(10000.0);
        salary.setTaxAmount(2500.0);
        salary.setSpecialAllowanceSalary(4500.0);

        employeeNew.setSalary(salary);

        componentMappingEmployeeRepository.save(employeeNew);

    }
}
