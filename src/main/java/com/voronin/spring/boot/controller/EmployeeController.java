package com.voronin.spring.boot.controller;

import com.voronin.spring.boot.entity.Employee;
import com.voronin.spring.boot.services.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> getEmployees() {
        return this.employeeService.findAll();
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable int id) {
        return this.employeeService.findById(id);
    }

    @PostMapping("/employees")
    public Employee saveEmployee(@RequestBody Employee employee) {
        return this.employeeService.save(employee);
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee) {
        this.employeeService.save(employee);
        return employee;
    }

    @DeleteMapping("/employees/{id}")
    public String deleteEmployee(@PathVariable int id) {
        this.employeeService.deleteById(id);
        return String.format("Employee with ID %s was deleted.", id);
    }

    @GetMapping("/employees/name/{name}")
    public List<Employee> findAllByName(@PathVariable String name) {
        return this.employeeService.findAllByName(name);
    }
}
