package com.jskno.taskmanagement.sandbox.applicationcontext;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = ApplicationContextConfig.class)
public class ApplicationContextConfig {
}
