package com.voronin.spring.aop.models;

import org.springframework.stereotype.Component;

@Component("magazineBean")
public class Magazine extends PrintedProduct {
    public Magazine() {
        super("Some magazine", "Some author", 2020);
    }
}
