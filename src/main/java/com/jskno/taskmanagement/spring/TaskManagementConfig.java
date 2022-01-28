package com.jskno.taskmanagement.spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import javax.annotation.PostConstruct;

@Configuration
@PropertySource("classpath:additional.properties")
public class TaskManagementConfig {

    private static final Logger LOG = LoggerFactory.getLogger(TaskManagementConfig.class);

    @Autowired
    private Environment environment;

    @PostConstruct
    private void postConstruct() {
        LOG.info("project suffix: {}", environment.getProperty("project.suffix"));
    }
}
