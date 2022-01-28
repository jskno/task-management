package com.jskno.taskmanagement.sandbox.circulardependency.setterinjection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CircularDependencyB {

//    @Autowired
    private CircularDependencyA circularDependencyA;

    private String message = "Hi!";

//    @Autowired
//    public CircularDependencyB(CircularDependencyA circularDependencyA) {
//        this.circularDependencyA = circularDependencyA;
//    }

    @Autowired
    public void setCircularDependencyA(CircularDependencyA circularDependencyA) {
        this.circularDependencyA = circularDependencyA;
    }

    public String getMessage() {
        return message;
    }
}
