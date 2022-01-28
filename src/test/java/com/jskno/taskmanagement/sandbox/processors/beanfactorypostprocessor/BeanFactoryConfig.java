package com.jskno.taskmanagement.sandbox.processors.beanfactorypostprocessor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanFactoryConfig {

    @Bean
    public Bank bank() {
        return new Bank();
    }


}
