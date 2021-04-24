package com.voronin.spring;

import com.voronin.spring.interfaces.Pet;

public class Person {
    private Pet pet;

    public Person(Pet pet) {
        this.pet = pet;
    }

    public void callYourPet() {
        System.out.println("Pet voice!");
        this.pet.say();
    }

    public Pet getPet() {
        return pet;
    }
}
