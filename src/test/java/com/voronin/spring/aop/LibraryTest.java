package com.voronin.spring.aop;

import com.voronin.spring.aop.config.SpringConfig;
import org.junit.After;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class LibraryTest {

    private final String sep = System.getProperty("line.separator");

    private final AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);

    private final Library libraryBean = context.getBean("libraryBean", Library.class);

    @After
    public void afterTest() {
        context.close();
    }

    @Test
    public void getBookOrMagazine() throws Exception {
        final String expectedOut = String.format("%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s",
                "beforeGetLoggingAdvise: writing log #1", sep,
                "beforeGetSecurityAdvise: checking the rights to receive a book or magazine!", sep,
                "beforeGetExceptionHandlingAdvise: catch an exception when trying to get a book or magazine!", sep,
                "We get the book!", sep,

                "beforeGetLoggingAdvise: writing log #1", sep,
                "beforeGetSecurityAdvise: checking the rights to receive a book or magazine!", sep,
                "beforeGetExceptionHandlingAdvise: catch an exception when trying to get a book or magazine!", sep,
                "We get the Magazine!", sep);

        final ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        libraryBean.getBook();
        libraryBean.getMagazine();
        assertThat(out.toString(), is(expectedOut));
    }
}