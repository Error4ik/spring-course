package com.voronin.spring.aop.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyPointcuts {
    @Pointcut("execution(* com.voronin.spring.aop.Library.add*(..))")
    public void allAddMethodsFromLibrary() {
    }
}