package com.voronin.spring.mvc.services;

import com.voronin.spring.mvc.dao.EmployeeDao;
import com.voronin.spring.mvc.model.Employee;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeDao employeeDao;

    public EmployeeServiceImpl(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    @Override
    @Transactional
    public List<Employee> getEmployees() {
        return this.employeeDao.getAllEmployees();
    }
}
