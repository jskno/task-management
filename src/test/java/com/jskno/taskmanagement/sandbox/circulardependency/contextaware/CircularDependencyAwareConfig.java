package com.jskno.taskmanagement.sandbox.circulardependency.contextaware;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.jskno.taskmanagement.sandbox.circulardependency.contextaware"})
public class CircularDependencyAwareConfig {
}
