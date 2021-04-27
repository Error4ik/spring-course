package com.voronin.spring;

import com.voronin.spring.interfaces.Pet;

public class Person {
//    @Value("${person.name}")
    private String name;
//    @Value("${person.surname}")
    private String surname;
//    @Value("${person.age}")
    private int age;
    private Pet pet;

    public Person() {
    }

    public Person(Pet pet) {
        this.pet = pet;
    }

    public void callYourPet() {
        System.out.println("Pet voice!");
        this.pet.say();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public Pet getPet() {
        return pet;
    }
}
