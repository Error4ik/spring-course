package com.voronin.spring.boot.repository;

import com.voronin.spring.boot.entity.Employee;

import java.util.List;

public interface EmployeeRepository {
    List<Employee> getEmployees();

    void saveOrUpdate(Employee employee);

    Employee getEmployee(int id);

    void deleteEmployee(int id);
}
