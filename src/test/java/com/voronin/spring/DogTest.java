package com.voronin.spring;

import com.voronin.spring.interfaces.Pet;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class DogTest {

    private final String sep = System.getProperty("line.separator");

    @Test
    public void sayTest() throws Exception {
        Pet dog = new Dog();

        final String expectedValue = String.format("Dog says Bow-Wow!%s", sep);
        final ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        dog.say();
        assertThat(out.toString(), is(expectedValue));
    }
}