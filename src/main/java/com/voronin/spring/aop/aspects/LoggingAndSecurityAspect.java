package com.voronin.spring.aop.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAndSecurityAspect {

    @Pointcut("execution(* com.voronin.spring.aop.Library.*(..))")
    private void allMethodsFromLibrary() {
    }

    @Pointcut("execution(public void com.voronin.spring.aop.Library.returnMagazine())")
    private void returnMagazineFromLibrary() {
    }

    @Pointcut("execution(* com.voronin.spring.aop.Library.get*())")
    private void allGetMethodsFromLibrary() {
    }

    @Pointcut("execution(* com.voronin.spring.aop.Library.return*())")
    private void allReturnMethodsFromLibrary() {
    }

    @Pointcut("allGetMethodsFromLibrary() || allReturnMethodsFromLibrary()")
    private void allGetAndReturnMethodsFromLibrary() {
    }

    @Pointcut("allMethodsFromLibrary() && !returnMagazineFromLibrary()")
    private void allMethodsExceptReturnMagazineFromLibrary() {
    }

    @Before("allGetMethodsFromLibrary()")
    public void beforeGetLoggingAdvise() {
        System.out.println("beforeGetLoggingAdvise: writing log #1");
    }

    @Before("allReturnMethodsFromLibrary()")
    public void beforeReturnLoggingAdvise() {
        System.out.println("beforeReturnLoggingAdvise: writing log #2");
    }

    @Before("allGetAndReturnMethodsFromLibrary()")
    public void beforeGetAndReturnLoggingAdvise() {
        System.out.println("beforeGetAndReturnLoggingAdvise: writing log #3");
    }

    @Before("allMethodsExceptReturnMagazineFromLibrary()")
    public void beforeAllMethodsExceptReturnMagazineFromLibrary() {
        System.out.println("beforeAllMethodsExceptReturnMagazineFromLibrary: writing log #10");
    }
}
