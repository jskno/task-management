package com.jskno.taskmanagement.sandbox.diByPrimary;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@ComponentScan(basePackages = {"com.jskno.taskmanagement.sandbox.diByPrimary"})
public class EmployeeModuleConfig {

    @Bean
    @Primary
    public Employee developerEmployee() {
        return new Employee("Developer");
    }

    @Bean
    public Employee architectEmployee() {
        return new Employee("Architect");
    }


}
