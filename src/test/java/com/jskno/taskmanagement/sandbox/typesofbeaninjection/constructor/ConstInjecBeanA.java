package com.jskno.taskmanagement.sandbox.typesofbeaninjection.constructor;

import org.springframework.stereotype.Service;

@Service
public class ConstInjecBeanA {

    private ConstInjecBeanB constInjecBeanB;

    public ConstInjecBeanA(ConstInjecBeanB constInjecBeanB) {
        this.constInjecBeanB = constInjecBeanB;
    }

    public String getMessage() {
        return "This is the man in charge..." + constInjecBeanB.getName();
    }
}
