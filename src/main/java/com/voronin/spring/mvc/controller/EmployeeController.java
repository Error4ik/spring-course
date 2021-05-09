package com.voronin.spring.mvc.controller;

import com.voronin.spring.mvc.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @RequestMapping("/")
    public String showIndexPage() {
        return "index";
    }

    @RequestMapping("/ask-details")
    public String askEmployeeDetails(Model model) {
        Employee employee = new Employee();
        employee.setName("Default Name");
        employee.setSurname("Default Surname");
        employee.setSalary(100);
        model.addAttribute("employee", employee);
        return "ask-employee-details-view";
    }

    @RequestMapping("/show-details")
    public String showEmployeeDetails(@ModelAttribute("employee") Employee emp) {
        emp.setName(emp.getName() + "!!!");
        emp.setSurname(emp.getSurname() + "!!!");
        emp.setSalary(emp.getSalary() * 10);
        return "show-employee-details-view";
    }
}
