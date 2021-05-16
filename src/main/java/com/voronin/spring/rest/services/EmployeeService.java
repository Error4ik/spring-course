package com.voronin.spring.rest.services;

import com.voronin.spring.rest.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getEmployees();

    void saveEmployee(Employee employee);

    Employee getEmployee(int id);

    void deleteEmployee(int id);
}
