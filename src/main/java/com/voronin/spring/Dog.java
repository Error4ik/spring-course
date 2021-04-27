package com.voronin.spring;

import com.voronin.spring.interfaces.Pet;
import org.springframework.stereotype.Component;

@Component("dogBean")
public class Dog implements Pet {

    @Override
    public void say() {
        System.out.println("Dog says Bow-Wow!");
    }
}
