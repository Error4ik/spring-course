package com.voronin.spring.aop.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LibraryLoggingAspect {

    @Around("execution(public String returnBook())")
    public Object aroundReturnBookLoggingAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("aroundReturnBookLoggingAdvice: Trying to return the book!");
        Object proceed = proceedingJoinPoint.proceed();
        System.out.println("aroundReturnBookLoggingAdvice: Returning the book!");
        return proceed;
    }
}
