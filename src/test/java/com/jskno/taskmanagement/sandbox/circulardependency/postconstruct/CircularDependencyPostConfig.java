package com.jskno.taskmanagement.sandbox.circulardependency.postconstruct;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.jskno.taskmanagement.sandbox.circulardependency.postconstruct"})
public class CircularDependencyPostConfig {
}
