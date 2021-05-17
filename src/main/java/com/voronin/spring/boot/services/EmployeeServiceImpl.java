package com.voronin.spring.boot.services;

import com.voronin.spring.boot.entity.Employee;
import com.voronin.spring.boot.repository.EmployeeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    @Transactional
    public List<Employee> getEmployees() {
        return this.employeeRepository.getEmployees();
    }

    @Override
    @Transactional
    public void saveEmployee(Employee employee) {
        this.employeeRepository.saveEmployee(employee);
    }

    @Override
    @Transactional
    public Employee getEmployee(int id) {
        return this.employeeRepository.getEmployee(id);
    }

    @Override
    @Transactional
    public void deleteEmployee(int id) {
        this.employeeRepository.deleteEmployee(id);
    }
}
