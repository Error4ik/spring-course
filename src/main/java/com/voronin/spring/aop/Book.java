package com.voronin.spring.aop;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Book {
    @Value("${The King's knight}")
    private String name;

    public String getName() {
        return name;
    }
}
