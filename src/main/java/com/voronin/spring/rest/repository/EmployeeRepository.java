package com.voronin.spring.rest.repository;

import com.voronin.spring.rest.entity.Employee;

import java.util.List;

public interface EmployeeRepository {
    List<Employee> getEmployees();

    void saveEmployee(Employee employee);

    Employee getEmployee(int id);

    void deleteEmployee(int id);
}
