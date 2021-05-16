package com.voronin.spring.mvc.controller;

import com.voronin.spring.mvc.model.Employee;
import com.voronin.spring.mvc.services.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @RequestMapping("/")
    public String showAllEmployees(Model model) {
        List<Employee> employees = this.employeeService.getEmployees();
        model.addAttribute("employees", employees);
        return "all-employees";
    }

    @RequestMapping("/add-employee")
    public String addEmployee(Model model) {
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "employee-info";
    }

    @RequestMapping("/save-employee")
    public String saveEmployee(@ModelAttribute(name = "employee") Employee employee) {
        this.employeeService.saveEmployee(employee);
        return "redirect:/";
    }

    @RequestMapping("/update-info")
    public String updateEmployee(@RequestParam("employeeId") int employeeId, Model model) {
        model.addAttribute("employee", this.employeeService.getEmployee(employeeId));
        return "employee-info";
    }

    @RequestMapping("/delete-employee")
    public String deleteEmployee(@RequestParam("employeeId") int employeeId) {
        this.employeeService.deleteEmployee(employeeId);
        return "redirect:/";
    }
}
