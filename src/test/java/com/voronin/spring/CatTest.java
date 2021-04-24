package com.voronin.spring;

import com.voronin.spring.interfaces.Pet;
import org.junit.After;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class CatTest {

    private final String sep = System.getProperty("line.separator");

    private final ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");

    private final Pet cat = context.getBean("cat", Pet.class);

    @After
    public void afterTest() {
        context.close();
    }

    @Test
    public void whenCallMethodSayShouldPrintMessage() throws Exception {
        final String expectedValue = String.format("Cat says Mew-Mew!%s", sep);
        final ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        cat.say();
        assertThat(out.toString(), is(expectedValue));
    }
}