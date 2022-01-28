package com.jskno.taskmanagement.sandbox.processors.initializationcycle;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = InitCycleConfig.class)
public class InitCycleConfig {

    @Bean
    public BankInitCycle bankInitCycle() {
        return new BankInitCycle();
    }


}
