package com.jskno.taskmanagement.sandbox.unsatisfieddependency;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
//@ComponentScan(basePackages = {"com.jskno.taskmanagement.sandbox.unsatisfieddependency.service"})
@ComponentScan(basePackages = {"com.jskno.taskmanagement.sandbox.unsatisfieddependency"})
public class PurchaseAppConfig {
}
