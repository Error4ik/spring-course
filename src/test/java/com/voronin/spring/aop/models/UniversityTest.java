package com.voronin.spring.aop.models;

import com.voronin.spring.aop.config.SpringConfig;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class UniversityTest {

    private final String sep = System.getProperty("line.separator");

    private final AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
    private final University university = context.getBean("university", University.class);
    private final List<Student> expectedStudents = new ArrayList<>();

    @After
    public void afterTest() {
        context.close();
    }

    @Before
    public void beforeTest() {
        expectedStudents.add(new Student("Alex", "Golovin", 3, 10.0));
        expectedStudents.add(new Student("Garry", "Solovey", 2, 10.0));
        expectedStudents.add(new Student("Diana", "Malaxova", 5, 10.0));
    }

    @Test
    public void getStudents() throws Exception {
        final String expectedOut = String.format("%s%s%s%s%s%s%s%s",
                "beforeGetStudentsLoggingAdvice: Logging get students!", sep,
                "Information from method getStudents:", sep,
                "[Student{name='Alex', surname='Golovin', course=3, avgGrade=8.3}, " +
                        "Student{name='Garry', surname='Solovey', course=2, avgGrade=7.9}, " +
                        "Student{name='Diana', surname='Malaxova', course=5, avgGrade=9.6}" +
                        "]", sep,
                "afterReturningGetStudentsLoggingAdvice: Logging get students!", sep);

        final ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        university.addStudent();
        List<Student> actualStudents = university.getStudents();

        assertThat(out.toString(), is(expectedOut));
        assertThat(actualStudents, is(expectedStudents));
    }
}
