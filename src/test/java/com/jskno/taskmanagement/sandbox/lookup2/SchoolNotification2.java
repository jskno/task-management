package com.jskno.taskmanagement.sandbox.lookup2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class SchoolNotification2 {

    @Autowired
    Grader grader;

    private String name;
    private Collection<Integer> marks;

    public SchoolNotification2(String name) {
        this.name = name;
        this.marks = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<Integer> getMarks() {
        return marks;
    }

    public void setMarks(Collection<Integer> marks) {
        this.marks = marks;
    }

    public String addMark(Integer mark) {
        this.marks.add(mark);
        return this.grader.grade(this.marks);
    }
}
