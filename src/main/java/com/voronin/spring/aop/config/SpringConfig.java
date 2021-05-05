package com.voronin.spring.aop.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("com.voronin.spring")
@EnableAspectJAutoProxy
public class SpringConfig {
}
