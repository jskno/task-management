package com.jskno.taskmanagement.sandbox.propertiesfiles;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class PropertiesFilesApp {

    private static final Logger LOG = LoggerFactory.getLogger(PropertiesFilesApp.class);

    @Autowired
    private ApplicationContext context;

    public static void main(String[] args) {
        SpringApplication.run(PropertiesFilesApp.class, args);
    }

    @PostConstruct
    public void init() {
        LOG.info("Property value injected: {}", context.getEnvironment().getProperty("database.url"));
    }
}
