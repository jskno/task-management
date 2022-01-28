package com.jskno.taskmanagement.sandbox.lifecycle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class LifecycleApp {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(new Class[]{LifecycleApp.class, LifecycleConfig.class}, args);
        context.close();
    }
}
