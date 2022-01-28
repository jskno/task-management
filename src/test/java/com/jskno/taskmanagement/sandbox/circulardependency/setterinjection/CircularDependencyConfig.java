package com.jskno.taskmanagement.sandbox.circulardependency.setterinjection;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.jskno.taskmanagement.sandbox.circulardependency"})
public class CircularDependencyConfig {
}
