package com.voronin.spring;

import com.voronin.spring.interfaces.Pet;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class CatTest {

    private final String sep = System.getProperty("line.separator");

    @Test
    public void sayTest() {
        Pet cat = new Cat();

        final String expectedValue = String.format("Cat says Mew-Mew!%s", sep);
        final ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        cat.say();
        assertThat(out.toString(), is(expectedValue));
    }
}