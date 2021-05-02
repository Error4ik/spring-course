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
    private final Book book = context.getBean("book", Book.class);

    @After
    public void afterTest() {
        context.close();
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

    @Test
    public void getBookWithBookName() throws Exception {
        final String expectedOut = String.format("%s%s",
                "beforeGetBookWithBookName: get book with name!", sep);
        final ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        String expectedBook = String.format("The book %s was returned!", book.getName());
        String actualBook = libraryBean.getBookWithBookName(book);
        assertThat(out.toString(), is(expectedOut));
        assertThat(actualBook, is(expectedBook));
    }
}