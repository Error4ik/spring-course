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
    public void getBookAndGetMagazine() {
        String expectedBook = "Some Book!";
        String expectedMagazine = "Some Magazine!";
        final String expectedOut = String.format("%s%s%s%s",
                "beforeGetAdvise: Before method get*()", sep,
                "beforeGetAdvise: Before method get*()", sep);
        final ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        String actualBook = libraryBean.getBook();
        String actualMagazine = libraryBean.getMagazine();

        assertThat(out.toString(), is(expectedOut));
        assertThat(expectedBook, is(actualBook));
        assertThat(expectedMagazine, is(actualMagazine));
    }

    @Test
    public void addBookAndAddMagazine() throws Exception {
        final String expectedOut = String.format("%s%s%s%s%s%s%s%s",
                "beforeAddAdvise: trying to add a book or magazine!", sep,
                "We added a book!", sep,
                "beforeAddAdvise: trying to add a book or magazine!", sep,
                "We added a Magazine!", sep);
        final ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        libraryBean.addBook();
        libraryBean.addMagazine();
        assertThat(out.toString(), is(expectedOut));
    }
}