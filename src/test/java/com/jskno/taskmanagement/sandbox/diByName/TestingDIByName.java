package com.jskno.taskmanagement.sandbox.diByName;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestingDIByName {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(DIByNameConfig.class);
        Client client = context.getBean(Client.class);
        System.out.println(client);

    }
}
