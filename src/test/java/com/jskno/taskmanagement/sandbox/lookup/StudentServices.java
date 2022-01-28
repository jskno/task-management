package com.jskno.taskmanagement.sandbox.lookup;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;

@Component
public class StudentServices {

    @Lookup
    public SchoolNotification getNotification() {
        return null;
    }

    public void mark(Student student, String subjectName, String mark) {
        student.addCalification(subjectName, mark, getNotification().getCreationDate());
    }
}
