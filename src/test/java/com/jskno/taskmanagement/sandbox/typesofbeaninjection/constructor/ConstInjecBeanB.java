package com.jskno.taskmanagement.sandbox.typesofbeaninjection.constructor;

import org.springframework.stereotype.Component;

@Component
public class ConstInjecBeanB {

    private String name;

    public ConstInjecBeanB() {
        // Default name
        this.name = "Jose Cano";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
