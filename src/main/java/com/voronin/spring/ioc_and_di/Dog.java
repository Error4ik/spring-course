package com.voronin.spring.ioc_and_di;

import com.voronin.spring.ioc_and_di.interfaces.Pet;

public class Dog implements Pet {

    @Override
    public void say() {
        System.out.println("Dog says Bow-Wow!");
    }
}
