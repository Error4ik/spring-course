package com.voronin.spring.aop;

import com.voronin.spring.aop.config.SpringConfig;
import org.junit.After;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.*;

public class LibraryTest {

    private final String sep = System.getProperty("line.separator");

    private final AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);

    private final Library libraryBean = context.getBean("libraryBean", Library.class);

    @After
    public void afterTest() {
        context.close();
    }

    @Test
    public void returnBook() throws Exception {
        String expectedBook = "War and peace";
        final String expectedOut = String.format("%s%s%s%s%s%s",
                "aroundReturnBookLoggingAdvice: Trying to return the book!", sep,
                "We are returning the Book!", sep,
                "aroundReturnBookLoggingAdvice: Returning the book!", sep);

        final ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        String actualBook = libraryBean.returnBook();

        assertThat(out.toString(), is(expectedOut));
        assertThat(actualBook, is(expectedBook));
    }
}
