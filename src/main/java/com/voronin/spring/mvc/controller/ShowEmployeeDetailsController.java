package com.voronin.spring.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ShowEmployeeDetailsController {

    @RequestMapping("/show-details")
    public String showEmployeeDetails() {
        return "show-employee-details-view";
    }
}
