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
    public void getBook() {
        final String expectedValue = String.format("%s%s%s%s%s%s%s%s",
                "beforeGetBookAdvise: trying to get a book!", sep,
                "We get the book!", sep,
                "beforeGetBookAdvise: trying to get a book!", sep,
                "We get the Magazine!", sep);
        final ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        libraryBean.getBook();
        libraryBean.getMagazine();
        assertThat(out.toString(), is(expectedValue));
    }
}