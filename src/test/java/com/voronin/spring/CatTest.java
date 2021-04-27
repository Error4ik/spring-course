package com.voronin.spring;

import com.voronin.spring.config.SpringConfig;
import com.voronin.spring.interfaces.Pet;
import org.junit.After;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class CatTest {

    private final String sep = System.getProperty("line.separator");

    private final AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);

    private final Pet cat = context.getBean("catBean", Pet.class);

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