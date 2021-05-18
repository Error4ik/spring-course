package com.voronin.spring.boot.services;

import com.voronin.spring.boot.entity.Employee;
import com.voronin.spring.boot.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        return this.employeeRepository.findAll();
    }

    @Override
    public Employee save(Employee employee) {
        return this.employeeRepository.save(employee);
    }

    @Override
    public Employee findById(int id) {
        return this.employeeRepository.findById(id).orElseGet(Employee::new);
    }

    @Override
    public void deleteById(int id) {
        this.employeeRepository.deleteById(id);
    }

    @Override
    public List<Employee> findAllByName(String name) {
        return this.employeeRepository.findAllByName(name);
    }
}
