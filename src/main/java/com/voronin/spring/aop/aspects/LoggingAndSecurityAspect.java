package com.voronin.spring.aop.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAndSecurityAspect {

    @Pointcut("execution(* get*())")
    private void allGetMethods() {
    }

    @Before("allGetMethods()")
    public void beforeGetBookOrMagazineAdvise() {
        System.out.println("beforeGetBookAdvise: trying to get a book or magazine!");
    }

    @Before("allGetMethods()")
    public void beforeGetSecurityAdvise() {
        System.out.println("beforeGetSecurityAdvise: checking the rights to receive a book or magazine!");
    }
}
