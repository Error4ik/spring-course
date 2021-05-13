package com.voronin.spring.mvc.dao;

import com.voronin.spring.mvc.model.Employee;

import java.util.List;

public interface EmployeeDao {
    public List<Employee> getAllEmployees();
}
