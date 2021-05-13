package com.voronin.spring.mvc.controller;

import com.voronin.spring.mvc.dao.EmployeeDao;
import com.voronin.spring.mvc.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class EmployeeController {

    private final EmployeeDao employeeDao;

    public EmployeeController(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    @RequestMapping("/")
    public String showAllEmployees(Model model) {
        List<Employee> employees = this.employeeDao.getAllEmployees();
        model.addAttribute("employees", employees);
        return "all-employees";
    }
}
