package com.voronin.spring.mvc.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyLoggingAspect {

    @Around("execution(* com.voronin.spring.mvc.dao.*.*(..))")
    public Object aroundAllRepositoryMethodsAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();
        String methodName = methodSignature.getName();
        System.out.println(String.format("The method (%s) started working", methodName));

        Object targetMethodResult = proceedingJoinPoint.proceed();

        System.out.println(String.format("The method (%s) has finished its work.", methodName));
        return targetMethodResult;
    }
}
