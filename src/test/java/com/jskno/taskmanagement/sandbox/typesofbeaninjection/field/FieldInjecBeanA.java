package com.jskno.taskmanagement.sandbox.typesofbeaninjection.field;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FieldInjecBeanA {

    @Autowired
    private FieldInjecBeanB fieldInjecBeanB;

    public String getMessage() {
        return "This is the man in charge..." + fieldInjecBeanB.getName();
    }
}
