package com.jskno.taskmanagement.sandbox.diByPrimary;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestingDIByPrimary {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(EmployeeModuleConfig.class);
        Company company = context.getBean(Company.class);
        System.out.println(company);;

    }
}
