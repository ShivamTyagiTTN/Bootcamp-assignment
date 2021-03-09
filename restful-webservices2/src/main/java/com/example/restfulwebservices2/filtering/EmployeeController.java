package com.example.restfulwebservices2.filtering;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class EmployeeController {

    @GetMapping("/employee")
    public Employee getEmployee() {
        return new Employee("Vipin", "xyz@321");
    }

//Q.9 Dynamic filtering
    @GetMapping("/employee-list")
    public MappingJacksonValue getAllEmployees() {

        List<Employee> employeeList = Arrays.asList(
                new Employee("Sumit", "abc@123"),
                new Employee("Raman", "abc@1234")
        );

        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("name");
        FilterProvider filters = new SimpleFilterProvider().addFilter("employeeFilter", filter);

        MappingJacksonValue mapping = new MappingJacksonValue(employeeList);
        mapping.setFilters(filters);

        return mapping;
    }

}
