package com.jskno.taskmanagement.sandbox.typesofbeaninjection.setter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SetterInjectionApp {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SetterInjectionApp.class);
        SetterInjecBeanA setterInjecBeanA = context.getBean(SetterInjecBeanA.class);
        System.out.println(setterInjecBeanA.getMessage());
    }
}
