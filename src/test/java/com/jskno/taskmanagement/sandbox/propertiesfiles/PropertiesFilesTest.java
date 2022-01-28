package com.jskno.taskmanagement.sandbox.propertiesfiles;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class PropertiesFilesTest {

    @Test
    public void testingPropertiesFiles() {
        ApplicationContext context = new AnnotationConfigApplicationContext(PropertiesFilesConfig.class);
        MyBeanWithPropertyValue myBeanWithPropertyValue = context.getBean(MyBeanWithPropertyValue.class);
        System.out.println(myBeanWithPropertyValue.getDatabaseUrl());
        System.out.println(myBeanWithPropertyValue.getDatabasePort());
    }

}
