package com.voronin.spring.boot.services;

import com.voronin.spring.boot.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();

    Employee save(Employee employee);

    Employee findById(int id);

    void deleteById(int id);

    List<Employee> findAllByName(String name);
}
