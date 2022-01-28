package com.jskno.taskmanagement.sandbox.processors.beanpostprocessorordered2;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class PostProcessorOrderedTest {

    @Test
    public void testingOrderedAndOnceInvocationForBeanSoTwoInvocationEach() {
        ApplicationContext context = new AnnotationConfigApplicationContext(PostProcessorOrderedConfig2.class);
    }
}
