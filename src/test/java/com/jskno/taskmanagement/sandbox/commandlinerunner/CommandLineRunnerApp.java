package com.jskno.taskmanagement.sandbox.commandlinerunner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:testAdditional.properties")
public class CommandLineRunnerApp {

    public static void main(String[] args) {
        SpringApplication.run(CommandLineRunnerApp.class, args);
    }
}
