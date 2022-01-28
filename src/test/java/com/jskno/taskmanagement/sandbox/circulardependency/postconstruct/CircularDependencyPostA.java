package com.jskno.taskmanagement.sandbox.circulardependency.postconstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class CircularDependencyPostA {

    @Autowired
    private CircularDependencyPostB circularDependencyB;

    public CircularDependencyPostA() {
        System.out.println("Inside CircularDependencyPostA Constructor");
    }

    @PostConstruct
    public void init() {
        System.out.println("Inside CircularDependencyPostA: @PostConstruct init method");
        circularDependencyB.setCircularDependencyA(this);
    }

    public CircularDependencyPostB getCircularDependencyB() {
        System.out.println("Inside getCircularDependencyB");
        return circularDependencyB;
    }


}
