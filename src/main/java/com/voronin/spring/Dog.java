package com.voronin.spring;

import com.voronin.spring.interfaces.Pet;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("dogBean")
@Scope("prototype")
public class Dog implements Pet {

    @Override
    public void say() {
        System.out.println("Dog says Bow-Wow!");
    }
}
