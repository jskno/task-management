package com.jskno.taskmanagement.sandbox.circulardependency.setterinjection;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CircularDependencyTest {

    @Test
    public void emptyTest() {
        ApplicationContext context = new AnnotationConfigApplicationContext(CircularDependencyConfig.class);
        CircularDependencyA circA = context.getBean(CircularDependencyA.class);
        Assertions.assertEquals("Hi!", circA.getCircularDependencyB().getMessage());
    }
}
