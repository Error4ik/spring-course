package com.voronin.spring.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ShowEmployeeDetailsController {

    @RequestMapping("/show-details")
    public String showEmployeeDetails(HttpServletRequest request, Model model) {
        String name = "Hello - " +  request.getParameter("employeeName") + "!!!";
        model.addAttribute("nameAttribute", name);
        model.addAttribute("description", "Developer");
        return "show-employee-details-view";
    }
}
