package com.voronin.spring;

import com.voronin.spring.interfaces.Pet;

public class Dog implements Pet {

    @Override
    public void say() {
        System.out.println("Dog says Bow-Wow!");
    }
}
