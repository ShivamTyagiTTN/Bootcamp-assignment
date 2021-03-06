package com.ttn.restfulwebservices.q2to9;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Component
public class EmployeeService {

    private static List<Employee> employeesList = new ArrayList<>();
    private static int employeeCount = 3;

    static {
        employeesList.add(new Employee(1, "Raman", 25));
        employeesList.add(new Employee(2, "Sumit", 23));
        employeesList.add(new Employee(3, "Akash", 21));
    }

    public List<Employee> getAllEmployees() {
        return employeesList;
    }

    public Employee addEmployee(Employee employee) {
        if (employee.getId() == 0)
            employee.setId(++employeeCount);

        employeesList.add(employee);
        return employee;
    }

    public Employee findEmployee(int id) {
        for (Employee emp : employeesList) {
            if (emp.getId() == id)
                return emp;
        }
        return null;
    }

    public Employee deleteEmployee(int id) {

        Iterator<Employee> iterator = employeesList.iterator();

        while (iterator.hasNext()) {
            Employee employee = iterator.next();

            if (employee.getId() == id) {
                iterator.remove();
                return employee;
            }
        }
        return null;
    }
}
