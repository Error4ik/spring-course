package com.voronin.spring.aop.aspects;

import com.voronin.spring.aop.models.PrintedProduct;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(1)
public class LoggingAspect {
    @Before("com.voronin.spring.aop.aspects.MyPointcuts.allAddMethodsFromLibrary()")
    public void beforeAddLoggingAdvise(JoinPoint joinPoint) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Object[] args = joinPoint.getArgs();

        System.out.println("beforeAddLoggingAdvise: writing log #1");
        System.out.println("---------------------------------------");
        System.out.println("Method: " + methodSignature.getMethod());
        for (Object arg : args) {
            if (arg instanceof String) {
                System.out.println(String.format("The product was added by %s", arg));
            } else if (arg instanceof PrintedProduct) {
                PrintedProduct printedProduct = (PrintedProduct) arg;
                System.out.println("Product name " + printedProduct.getName());
                System.out.println("Product author " + printedProduct.getAuthor());
                System.out.println("Product year of publication " + printedProduct.getYearOfPublication());
            }
        }
        System.out.println("---------------------------------------");
    }
}
