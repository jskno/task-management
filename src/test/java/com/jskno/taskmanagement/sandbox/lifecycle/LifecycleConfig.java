package com.jskno.taskmanagement.sandbox.lifecycle;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LifecycleConfig {

    @Bean
    public LifecycleBeanA lifecycleBeanA() {
        return new LifecycleBeanA();
    }

    // Instead of @PostConstruct in the bean class
    // This is useful when we want to keep configuration out of
    // our domain logic.
    @Bean(initMethod = "init", destroyMethod = "preDestroy")
    public LifecycleBeanB lifecycleBeanB() {
        return new LifecycleBeanB();
    }
}
