package com.jskno.taskmanagement.sandbox.testframework.dirtiescontext;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
@ComponentScan(basePackageClasses = DirtiesContextConfig.class)
public class DirtiesContextConfig {
}
