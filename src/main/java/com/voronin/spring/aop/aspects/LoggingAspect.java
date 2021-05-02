package com.voronin.spring.aop.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

    @Before("execution(public void add*())")
    public void beforeAddAdvise() {
        System.out.println("beforeAddAdvise: trying to add a book or magazine!");
    }

    @Before("execution(* getBookWithBookName(com.voronin.spring.aop.Book))")
    public void beforeGetBookWithBookName() {
        System.out.println("beforeGetBookWithBookName: get book with name!");
    }
}
