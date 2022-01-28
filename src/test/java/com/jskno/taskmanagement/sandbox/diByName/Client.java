package com.jskno.taskmanagement.sandbox.diByName;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.annotation.PostConstruct;

public class Client {

    // By type (1st order precedence)
    @Autowired
    private SpecificDependency specificDependency666;

    // By name (3rd order precedence)
    @Autowired
    private ArbitraryDependency autowiredField;

    // By qualifier (2nd order precedence)
    @Autowired
    @Qualifier("autowiredField")
    private ArbitraryDependency autowiredField1;

    // By qualifier (2nd order precedence)
    @Autowired
    @Qualifier("anotherAutowiredField")
    private ArbitraryDependency autowiredField2;

    @PostConstruct
    public void init() {
        System.out.println("Dependencies injected !!");
    }
}
