package com.voronin.spring.aop.models;

import org.springframework.stereotype.Component;

@Component("bookBean")
public class Book extends PrintedProduct {
    public Book() {
        super("The King's knight", "Some author", 1980);
    }
}
