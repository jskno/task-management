package com.jskno.taskmanagement.sandbox.processors.beanpostprocessorordered;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PostProcessorOrderedApp {

    /*
    If we launch the app, the postProcessor methods we be called many, many times.
    This is because the bean post processor will be executed after every bean creation.
     As we are starting Spring Boot Application, many default beans will be created and for each one our
     class method will be called.
     If you run the app through the test class, only once is called because we are not running Boot context.
     Go to beanpostprocessordered2
     */
    public static void main(String[] args) {
        SpringApplication.run(PostProcessorOrderedApp.class, args);
    }
}
