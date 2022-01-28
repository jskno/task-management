package com.jskno.taskmanagement.sandbox.processors.beanpostprocessor;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = PostProcessorConfig.class)
public class PostProcessorConfig {
}
