package com.voronin.spring.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AskEmployeeDetailsController {

    @RequestMapping("/ask-details")
    public String askEmployeeDetails() {
        return "ask-employee-details-view";
    }
}
