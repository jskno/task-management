package com.jskno.taskmanagement.sandbox.typesofbeaninjection.field;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class FieldInjectionApp {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(FieldInjectionApp.class);
        FieldInjecBeanA fieldInjecBeanA = context.getBean(FieldInjecBeanA.class);
        System.out.println(fieldInjecBeanA.getMessage());
    }
}
