package com.voronin.spring.aop;

import org.springframework.stereotype.Component;

@Component("libraryBean")
public class Library {

    public String getBook() {
        return "Some Book!";
    }

    public String getMagazine() {
        return "Some Magazine!";
    }

    public void addBook() {
        System.out.println("We added a book!");
    }

    public void addMagazine() {
        System.out.println("We added a Magazine!");
    }
}
