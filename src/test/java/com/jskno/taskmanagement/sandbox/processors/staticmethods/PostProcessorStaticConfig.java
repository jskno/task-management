package com.jskno.taskmanagement.sandbox.processors.staticmethods;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PostProcessorStaticConfig {

    @Bean
    public static ProjectRepositoryStatic projectRepositoryStatic() {
        return new ProjectRepositoryStatic();
    }

    @Bean
    public static ProjectServiceStatic projectServiceStatic() {
        return new ProjectServiceStatic();
    }
}
