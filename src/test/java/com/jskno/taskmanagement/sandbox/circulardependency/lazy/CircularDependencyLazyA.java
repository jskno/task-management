package com.jskno.taskmanagement.sandbox.circulardependency.lazy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class CircularDependencyLazyA {

    private CircularDependencyLazyB circularDependencyB;

    @Autowired
    public CircularDependencyLazyA(@Lazy CircularDependencyLazyB circularDependencyB) {
        System.out.println("Inside CircularDependencyLazyA Constructor");
        this.circularDependencyB = circularDependencyB;
    }

    public CircularDependencyLazyB getCircularDependencyB() {
        System.out.println("Inside getCircularDependencyB");
        return circularDependencyB;
    }
}
