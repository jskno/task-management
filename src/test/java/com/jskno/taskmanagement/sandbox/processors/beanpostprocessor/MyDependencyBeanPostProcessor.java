package com.jskno.taskmanagement.sandbox.processors.beanpostprocessor;

import org.springframework.stereotype.Component;

@Component
public class MyDependencyBeanPostProcessor {

    private String name = "Default name";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
