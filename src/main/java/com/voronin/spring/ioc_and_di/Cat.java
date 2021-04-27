package com.voronin.spring.ioc_and_di;

import com.voronin.spring.ioc_and_di.interfaces.Pet;

public class Cat implements Pet {
    @Override
    public void say() {
        System.out.println("Cat says Mew-Mew!");
    }
}
