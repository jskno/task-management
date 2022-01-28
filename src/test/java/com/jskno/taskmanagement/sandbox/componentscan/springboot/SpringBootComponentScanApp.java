package com.jskno.taskmanagement.sandbox.componentscan.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
public class SpringBootComponentScanApp {

    private static ApplicationContext applicationContext;

    @Bean
    public BootExampleBean bootExampleBean() {
        return new BootExampleBean();
    }

    public static void main(String[] args) {
        applicationContext = SpringApplication.run(SpringBootComponentScanApp.class, args);
        checkBeansPresence(
                "bootCat", "bootDog", "bootRose", "bootExampleBean", "springBootComponentScanApp", "whatEver"
        );
    }

    private static void checkBeansPresence(String... beans) {
        Arrays.stream(beans).forEach(beanName -> System.out.println(
                "Is " + beanName + " in ApplicationContext: " + applicationContext.containsBean(beanName)
        ));
    }
}
