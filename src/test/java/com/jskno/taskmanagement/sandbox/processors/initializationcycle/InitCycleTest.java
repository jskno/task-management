package com.jskno.taskmanagement.sandbox.processors.initializationcycle;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class InitCycleTest {

    @Test
    public void testingInitCycle() {
        ApplicationContext context = new AnnotationConfigApplicationContext(InitCycleConfig.class);
    }
}
