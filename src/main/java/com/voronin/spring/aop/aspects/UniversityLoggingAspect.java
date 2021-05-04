package com.voronin.spring.aop.aspects;

import com.voronin.spring.aop.models.Student;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Aspect
public class UniversityLoggingAspect {

    @Before("execution(* getStudents())")
    public void beforeGetStudentsLoggingAdvice() {
        System.out.println("beforeGetStudentsLoggingAdvice: Logging get students!");
    }

    @AfterReturning(pointcut = "execution(* getStudents())", returning = "students")
    public void afterReturningGetStudentsLoggingAdvice(List<Student> students) {
        students.forEach(s -> s.setAvgGrade(10.0));
        System.out.println("afterReturningGetStudentsLoggingAdvice: Logging get students!");
    }
}
