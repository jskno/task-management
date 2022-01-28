package com.jskno.taskmanagement.sandbox.circulardependency.postconstruct;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CircularDependencyPostTest {

    @Test
    public void emptyTest() {
        ApplicationContext context = new AnnotationConfigApplicationContext(CircularDependencyPostConfig.class);
        CircularDependencyPostA circA = context.getBean(CircularDependencyPostA.class);
        System.out.println("Inside emptyTests All beans have been created");
        Assertions.assertEquals("Hi!", circA.getCircularDependencyB().getMessage());
    }
}
