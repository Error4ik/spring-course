package com.voronin.spring.aop.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(3)
public class ExceptionHandlingAspect {
    @Before("com.voronin.spring.aop.aspects.MyPointcuts.allGetMethodsFromLibrary()")
    public void beforeGetExceptionHandlingAdvise() {
        System.out.println("beforeGetExceptionHandlingAdvise: catch an exception when trying to get a book or magazine!");
    }
}
