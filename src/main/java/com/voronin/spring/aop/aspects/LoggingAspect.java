package com.voronin.spring.aop.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(1)
public class LoggingAspect {
    @Before("com.voronin.spring.aop.aspects.MyPointcuts.allGetMethodsFromLibrary()")
    public void beforeGetLoggingAdvise() {
        System.out.println("beforeGetLoggingAdvise: writing log #1");
    }
}
