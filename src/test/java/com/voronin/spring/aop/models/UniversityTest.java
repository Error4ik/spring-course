package com.voronin.spring.aop.models;

import com.voronin.spring.aop.config.SpringConfig;
import org.junit.After;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class UniversityTest {

    private final String sep = System.getProperty("line.separator");

    private final AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
    private final University university = context.getBean("university", University.class);

    @After
    public void afterTest() {
        context.close();
    }

    @Test
    public void getStudents() throws Exception {
        final String expectedOut = String.format("%s%s%s%s%s%s%s%s",
                "beforeGetStudentsLoggingAdvice: Logging get students!", sep,
                "Information from method getStudents:", sep,
                "afterThrowingGetStudentsLoggingAdvice: Logging Throwing exception: java.lang.IndexOutOfBoundsException: Index: 3, Size: 3", sep,
                "Catch Exception java.lang.IndexOutOfBoundsException: Index: 3, Size: 3", sep);

        final ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        university.addStudent();
        try {
            university.getStudents();
        } catch (Exception e) {
            System.out.println(String.format("Catch Exception %s", e));
        }

        assertThat(out.toString(), is(expectedOut));
    }
}
