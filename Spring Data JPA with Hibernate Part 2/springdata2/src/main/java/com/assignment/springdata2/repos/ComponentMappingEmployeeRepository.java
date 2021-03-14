package com.assignment.springdata2.repos;

import com.assignment.springdata2.entities.component.mapping.EmployeeNew;
import org.springframework.data.repository.CrudRepository;

public interface ComponentMappingEmployeeRepository extends CrudRepository<EmployeeNew, Integer> {
}
