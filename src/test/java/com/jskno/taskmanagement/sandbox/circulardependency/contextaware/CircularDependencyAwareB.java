package com.jskno.taskmanagement.sandbox.circulardependency.contextaware;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CircularDependencyAwareB {

    private CircularDependencyAwareA circularDependencyAwareA;

    private String message = "Hi!";

    @Autowired
    public void setCircularDependencyAwareA(CircularDependencyAwareA circularDependencyAwareA) {
        this.circularDependencyAwareA = circularDependencyAwareA;
    }

    public String getMessage() {
        return message;
    }
}
