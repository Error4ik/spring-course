package com.voronin.spring.ioc_and_di.config;

import com.voronin.spring.ioc_and_di.Cat;
import com.voronin.spring.ioc_and_di.Dog;
import com.voronin.spring.ioc_and_di.Person;
import com.voronin.spring.ioc_and_di.interfaces.Pet;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

@Configuration
@PropertySource("classpath:application.properties")
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
