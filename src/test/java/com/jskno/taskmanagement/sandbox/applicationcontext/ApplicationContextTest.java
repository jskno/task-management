package com.jskno.taskmanagement.sandbox.applicationcontext;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextTest {

    @Test
    public void testingApplicationContext() {
        ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationContextConfig.class);
    }
}
