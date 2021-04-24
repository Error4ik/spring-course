package com.voronin.spring;

import com.voronin.spring.interfaces.Pet;
import org.junit.After;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class DogTest {

    private final String sep = System.getProperty("line.separator");

    private final ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");

    private final Pet dog = context.getBean("dog", Pet.class);

    @After
    public void afterTest() {
        context.close();
    }

    @Test
    public void whenCallMethodSayShouldPrintMessage() throws Exception {
        final String expectedValue = String.format("Dog says Bow-Wow!%s", sep);
        final ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        dog.say();
        assertThat(out.toString(), is(expectedValue));
    }
}