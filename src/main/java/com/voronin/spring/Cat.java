package com.voronin.spring;

import com.voronin.spring.interfaces.Pet;

public class Cat implements Pet {
    @Override
    public void say() {
        System.out.println("Cat says Mew-Mew!");
    }
}
