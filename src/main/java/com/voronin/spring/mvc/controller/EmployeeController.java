package com.voronin.spring.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @RequestMapping("/")
    public String showIndexPage() {
        return "index";
    }

    @RequestMapping("/ask-details")
    public String askEmployeeDetails() {
        return "ask-employee-details-view";
    }

    @RequestMapping("/show-details")
    public String showEmployeeDetails(@RequestParam(name = "employeeName") String empName, Model model) {
        String name = "Hello - " + empName + "!!!";
        model.addAttribute("nameAttribute", name);
        return "show-employee-details-view";
    }
}
