package com.voronin.spring.aop;

import org.springframework.stereotype.Component;

@Component("libraryBean")
public class Library {

    public void addBook() {
        System.out.println("We added a book!");
    }

    public void addMagazine() {
        System.out.println("We added a Magazine!");
    }

    public String getBookWithBookName(Book book) {
        return String.format("The book %s was returned!", book.getName());
    }
}
