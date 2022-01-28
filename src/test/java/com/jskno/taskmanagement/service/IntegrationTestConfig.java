package com.jskno.taskmanagement.service;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = "com.jskno.taskmanagement")
@ComponentScan(excludeFilters =
    @ComponentScan.Filter(type = FilterType.REGEX,
        pattern = "com\\.jskno\\.taskmanagement\\.sandbox\\..*"))
@PropertySource("classpath:application.properties")
public class IntegrationTestConfig {
}
