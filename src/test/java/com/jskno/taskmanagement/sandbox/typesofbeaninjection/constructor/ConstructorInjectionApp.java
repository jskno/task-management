package com.jskno.taskmanagement.sandbox.typesofbeaninjection.constructor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ConstructorInjectionApp {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(ConstructorInjectionApp.class);
        ConstInjecBeanA constInjecBeanA = context.getBean(ConstInjecBeanA.class);
        System.out.println(constInjecBeanA.getMessage());
    }
}
