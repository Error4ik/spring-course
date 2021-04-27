package com.voronin.spring;

import com.voronin.spring.config.SpringConfig;
import org.junit.After;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class PersonTest {

    private final String sep = System.getProperty("line.separator");

    private final AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);

    private final Person person = context.getBean("personBean", Person.class);

    @After
    public void afterTest() {
        context.close();
    }

    @Test
    public void whenPetIsDogShouldPetDogSay() {
        final String expectedValue = String.format("Pet voice!%s%s%s", sep, "Dog says Bow-Wow!", sep);
        final ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        person.callYourPet();
        assertThat(out.toString(), is(expectedValue));
    }
}