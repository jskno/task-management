package com.jskno.taskmanagement.sandbox.circulardependency.lazy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CircularDependencyLazyB {

    private CircularDependencyLazyA circularDependencyA;

    private String message = "Hi!";

    @Autowired
    public CircularDependencyLazyB(CircularDependencyLazyA circularDependencyA) {
        System.out.println("Inside CircularDependencyLazyB Constructor");
        this.circularDependencyA = circularDependencyA;
    }

    public String getMessage() {
        return message;
    }
}
