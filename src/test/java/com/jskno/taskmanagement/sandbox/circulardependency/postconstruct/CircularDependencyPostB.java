package com.jskno.taskmanagement.sandbox.circulardependency.postconstruct;

import org.springframework.stereotype.Component;

@Component
public class CircularDependencyPostB {

    private CircularDependencyPostA circularDependencyA;
    private String message = "Hi!";

    public CircularDependencyPostB() {
        System.out.println("Inside CircularDependencyPostB: Constructor");
    }

    public void setCircularDependencyA(CircularDependencyPostA circularDependencyA) {
        System.out.println("Inside CircularDependencyPostB: setCircularDependencyA");
        this.circularDependencyA = circularDependencyA;
    }

    public String getMessage() {
        return message;
    }
}
