package com.assignment.springdata2.repos;

import com.assignment.springdata2.entities.jpql.sql.Employee;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface JpqlEmployeeRepository extends CrudRepository<Employee, Integer> {

    @Query("SELECT firstName, lastName from Employee where " +
            "salary > (select AVG(salary) from Employee)")
    List<Object[]> findAllEmployee(Sort sort);

    @Query("Select AVG(salary) from Employee")
    int findAverageSalary();

    @Modifying
    @Query("update Employee e set e.salary=:salary where e.salary <:avgSalary")
    void updateBelowAvgEmpSalary(@Param("salary") int salary, @Param("avgSalary") int avgSalary);

    @Query("Select MIN(salary) from Employee")
    int findMinSalary();

    @Modifying
    @Query("DELETE FROM Employee WHERE salary =:minSalary")
    void deleteEmployeeMinSalary(@Param("minSalary") int minSalary);

    @Query(value = "SELECT empid, empfirstname, empage from employee where emplastname like '%singh'", nativeQuery = true)
    List<Object[]> getAllEmployeeNameEndsWith();

    @Modifying
    @Query(value = "DELETE from employee where empage>:age", nativeQuery = true)
    void deleteEmployeeAgeGreaterThan(@Param("age") int age);


}

