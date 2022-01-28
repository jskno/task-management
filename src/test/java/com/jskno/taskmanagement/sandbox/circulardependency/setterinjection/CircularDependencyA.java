package com.jskno.taskmanagement.sandbox.circulardependency.setterinjection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CircularDependencyA {

//    @Autowired
    private CircularDependencyB circularDependencyB;

//    @Autowired
//    public CircularDependencyA(CircularDependencyB circularDependencyB) {
//        this.circularDependencyB = circularDependencyB;
//    }

    @Autowired
    public void setCircularDependencyB(CircularDependencyB circularDependencyB) {
        this.circularDependencyB = circularDependencyB;
    }

    public CircularDependencyB getCircularDependencyB() {
        return circularDependencyB;
    }
}
