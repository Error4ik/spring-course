package com.voronin.spring.aop;

import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component("libraryBean")
public class Library {

    public void getBook() {
        System.out.println("We get the book!");
    }
}
