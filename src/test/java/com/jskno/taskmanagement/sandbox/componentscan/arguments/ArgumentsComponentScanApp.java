package com.jskno.taskmanagement.sandbox.componentscan.arguments;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
@ComponentScan(basePackages = {"com.jskno.taskmanagement.sandbox.componentscan.arguments.animal"})
public class ArgumentsComponentScanApp {

    private static ApplicationContext applicationContext;

    @Bean
    public ArgExampleBean argExampleBean() {
        return new ArgExampleBean();
    }

    public static void main(String[] args) {

        applicationContext = new AnnotationConfigApplicationContext(ArgumentsComponentScanApp.class);
        Arrays.stream(applicationContext.getBeanDefinitionNames())
                .forEach(beanName -> System.out.println(beanName));
    }
}
