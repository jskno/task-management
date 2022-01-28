package com.jskno.taskmanagement.sandbox.factorybean;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Assertions;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Testing {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

        EmployeeDTO manager = (EmployeeDTO) context.getBean("manager");
        System.out.println(manager);

        EmployeeDTO director = (EmployeeDTO) context.getBean("director");
        System.out.println(director);

        EmployeeDTO architect = (EmployeeDTO) context.getBean("architect");
        System.out.println(architect);

        EmployeeDTO architect2 = (EmployeeDTO) context.getBean("architect");
        System.out.println(architect2);

        EmployeeDTO developer = (EmployeeDTO) context.getBean("developer");
        System.out.println(developer);

        EmployeeDTO developer2 = (EmployeeDTO) context.getBean("developer");
        System.out.println(developer2);

        MatcherAssert.assertThat(architect.getDesignation(), CoreMatchers.equalTo("Architect"));
        MatcherAssert.assertThat(developer.getDesignation(), CoreMatchers.equalTo("Developer"));
        Assertions.assertTrue(architect == architect2);
        Assertions.assertTrue(developer != developer2);
    }
}
