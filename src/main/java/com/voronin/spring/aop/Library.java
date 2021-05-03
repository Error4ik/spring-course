package com.voronin.spring.aop;

import org.springframework.stereotype.Component;

@Component("libraryBean")
public class Library {

    public void getBook() {
        System.out.println("We get the book!");
    }

    public void returnBook() {
        System.out.println("We are returning the Book!");
    }

    public void addBook() {
        System.out.println("We are adding the Book!");
    }

    public void getMagazine() {
        System.out.println("We get the Magazine!");
    }

    public void returnMagazine() {
        System.out.println("We are returning the Magazine!");
    }

    public void addMagazine() {
        System.out.println("We are adding the Magazine!");
    }
}
