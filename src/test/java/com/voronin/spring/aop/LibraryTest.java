package com.voronin.spring.aop;

import com.voronin.spring.aop.config.SpringConfig;
import com.voronin.spring.aop.models.Book;
import com.voronin.spring.aop.models.Magazine;
import com.voronin.spring.aop.models.PrintedProduct;
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
    private final PrintedProduct book = context.getBean("bookBean", Book.class);
    private final PrintedProduct magazine = context.getBean("magazineBean", Magazine.class);

    @After
    public void afterTest() {
        context.close();
    }

    @Test
    public void addBook() throws Exception {
        final String expectedOut = String.format("%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s",
                "beforeAddLoggingAdvise: writing log #1", sep,
                "---------------------------------------", sep,
                "Method: public void com.voronin.spring.aop.Library.addPrintedProduct(java.lang.String,com.voronin.spring.aop.models.PrintedProduct)", sep,
                "The product was added by Alex", sep,
                "Product name The King's knight", sep,
                "Product author Some author", sep,
                "Product year of publication 1980", sep,
                "---------------------------------------", sep,
                "beforeAddSecurityAdvise: checking the rights to receive a book or magazine!", sep,
                "beforeAddExceptionHandlingAdvise: catch an exception when trying to get a book or magazine!", sep,
                "We are adding the The King's knight!", sep);

        final ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        libraryBean.addPrintedProduct("Alex", book);
        assertThat(out.toString(), is(expectedOut));
    }

    @Test
    public void addMagazine() throws Exception {
        final String expectedOut = String.format("%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s",
                "beforeAddLoggingAdvise: writing log #1", sep,
                "---------------------------------------", sep,
                "Method: public void com.voronin.spring.aop.Library.addPrintedProduct(java.lang.String,com.voronin.spring.aop.models.PrintedProduct)", sep,
                "The product was added by Garry", sep,
                "Product name Some magazine", sep,
                "Product author Some author", sep,
                "Product year of publication 2020", sep,
                "---------------------------------------", sep,
                "beforeAddSecurityAdvise: checking the rights to receive a book or magazine!", sep,
                "beforeAddExceptionHandlingAdvise: catch an exception when trying to get a book or magazine!", sep,
                "We are adding the Some magazine!", sep);

        final ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        libraryBean.addPrintedProduct("Garry", magazine);
        assertThat(out.toString(), is(expectedOut));
    }
}