package com.jskno.taskmanagement.sandbox.circulardependency.contextaware;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CircularDependencyAwareTest {

    @Test
    public void emptyTest() {
        ApplicationContext context = new AnnotationConfigApplicationContext(CircularDependencyAwareConfig.class);
        CircularDependencyAwareA circA = context.getBean(CircularDependencyAwareA.class);
        System.out.println("Inside emptyTests All beans have been created");
        Assertions.assertEquals("Hi!", circA.getCircularDependencyAwareB().getMessage());
    }
}
