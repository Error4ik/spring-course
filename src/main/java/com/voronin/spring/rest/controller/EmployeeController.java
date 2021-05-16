package com.voronin.spring.rest.controller;

import com.voronin.spring.rest.entity.Employee;
import com.voronin.spring.rest.exception_handling.NoSuchEmployeeException;
import com.voronin.spring.rest.services.EmployeeService;
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
        return this.employeeService.getEmployees();
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable int id) {
        Employee employee = this.employeeService.getEmployee(id);
        if (employee == null) {
            throw new NoSuchEmployeeException(String.format("There is no Employee with id %s in Database", id));
        }
        return employee;
    }
}
