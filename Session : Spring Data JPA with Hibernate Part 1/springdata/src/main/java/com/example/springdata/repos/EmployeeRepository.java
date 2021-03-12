//  Q.2 Set up EmployeeRepository with Spring Data JPA

package com.example.springdata.repos;

import com.example.springdata.entities.Employee;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface EmployeeRepository extends PagingAndSortingRepository<Employee, Integer> {

    List<Employee> findByName(String name);
    List<Employee> findByNameLike(String name);
    List<Employee> findByAgeBetween(int age1, int age2);
    List<Employee> findAll();

}
