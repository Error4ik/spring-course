package com.voronin.spring.config;

import com.voronin.spring.Cat;
import com.voronin.spring.Dog;
import com.voronin.spring.Person;
import com.voronin.spring.interfaces.Pet;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class SpringConfig {

    @Bean
    @Scope("prototype")
    public Pet getDogBean() {
        return new Dog();
    }

    @Bean
    public Pet getCatBean() {
        return new Cat();
    }

    @Bean
    public Person getPersonBean() {
        return new Person(getDogBean());
    }
}
