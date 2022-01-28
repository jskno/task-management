package com.jskno.taskmanagement.sandbox.factorybean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DemoConfig {

    @Bean EmployeeFactoryBean director() {
        EmployeeFactoryBean director = new EmployeeFactoryBean();
        director.setDesignation("Director");
        return director;
    }

    @Bean EmployeeFactoryBean manager() {
        EmployeeFactoryBean manager = new EmployeeFactoryBean();
        manager.setDesignation("Manager");
        return manager;
    }

    @Bean ITEmployeeFactoryBean architect() {
        ITEmployeeFactoryBean director = new ITEmployeeFactoryBean(true, "Architect");
        return director;
    }

    @Bean ITEmployeeFactoryBean developer() {
        ITEmployeeFactoryBean manager = new ITEmployeeFactoryBean(false, "Developer");
        return manager;
    }
}
