package com.jskno.taskmanagement.sandbox.typesofbeaninjection.field;

import org.springframework.stereotype.Component;

@Component
public class FieldInjecBeanB {

    private String name;

    public FieldInjecBeanB() {
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
