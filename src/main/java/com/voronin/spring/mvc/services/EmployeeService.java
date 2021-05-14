package com.voronin.spring.mvc.services;

import com.voronin.spring.mvc.model.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getEmployees();

    void saveEmployee(Employee employee);
}
