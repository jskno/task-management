package com.jskno.taskmanagement.sandbox.processors.beanpostprocessor;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class PostProcessorTest {

    @Test
    public void postProcessorTesting() {
        ApplicationContext context = new AnnotationConfigApplicationContext(PostProcessorConfig.class);

    }
}
