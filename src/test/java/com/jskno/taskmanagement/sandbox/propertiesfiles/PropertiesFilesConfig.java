package com.jskno.taskmanagement.sandbox.propertiesfiles;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackageClasses = PropertiesFilesConfig.class)
@PropertySource("classpath:custom.properties")
public class PropertiesFilesConfig {
}
