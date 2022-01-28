package com.jskno.taskmanagement.sandbox.lookup2;

import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class Grader {

    public String grade(Collection<Integer> marks) {
        return marks.stream().anyMatch(mark -> mark < 45) ? "FAIL" : "PASS";
    }
}
