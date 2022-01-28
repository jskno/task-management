package com.jskno.taskmanagement.sandbox.typesofbeaninjection.setter;

import org.springframework.stereotype.Component;

@Component
public class SetterInjecBeanB {

    private String name;

    public SetterInjecBeanB() {
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
