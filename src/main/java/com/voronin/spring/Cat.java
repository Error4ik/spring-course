package com.voronin.spring;

import com.voronin.spring.interfaces.Pet;
import org.springframework.stereotype.Component;

@Component("catBean")
public class Cat implements Pet {
    @Override
    public void say() {
        System.out.println("Cat says Mew-Mew!");
    }
}
