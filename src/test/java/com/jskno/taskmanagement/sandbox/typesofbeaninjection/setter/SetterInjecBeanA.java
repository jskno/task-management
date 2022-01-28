package com.jskno.taskmanagement.sandbox.typesofbeaninjection.setter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SetterInjecBeanA {

    private SetterInjecBeanB setterInjecBeanB;

    @Autowired
    public void setSetterInjecBeanB(SetterInjecBeanB setterInjecBeanB) {
        this.setterInjecBeanB = setterInjecBeanB;
    }

    public String getMessage() {
        return "This is the man in charge..." + setterInjecBeanB.getName();
    }
}
