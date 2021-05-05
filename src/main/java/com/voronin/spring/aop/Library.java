package com.voronin.spring.aop;

import org.springframework.stereotype.Component;

@Component("libraryBean")
public class Library {
    public String returnBook() {
        System.out.println("We are returning the Book!");
        return "War and peace";
    }
}
