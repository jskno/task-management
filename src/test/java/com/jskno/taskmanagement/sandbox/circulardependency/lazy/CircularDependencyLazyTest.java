package com.jskno.taskmanagement.sandbox.circulardependency.lazy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CircularDependencyLazyTest {

    @Test
    public void emptyTest() {
        ApplicationContext context = new AnnotationConfigApplicationContext(CircularDependencyLazyConfig.class);
        CircularDependencyLazyA circA = context.getBean(CircularDependencyLazyA.class);
        System.out.println("Inside emptyTests All beans have been created");
        Assertions.assertEquals("Hi!", circA.getCircularDependencyB().getMessage());
    }
}
