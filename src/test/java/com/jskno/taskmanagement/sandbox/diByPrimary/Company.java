package com.jskno.taskmanagement.sandbox.diByPrimary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.annotation.PostConstruct;

public class Company {

    // By @Primary annotation
    @Autowired
    private Employee employee1;

    // By qualifier
    @Autowired
    @Qualifier("architectEmployee")
    private Employee employee2;

    // By bean name does not work when defining a primary
    // This is actually a developer employee.
    @Autowired
    private Employee architectEmployee;

    @PostConstruct
    public void init() {
        System.out.println("Fields correctly autowired");
    }
}
