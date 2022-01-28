package com.jskno.taskmanagement.sandbox.lookup2;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;

@Component("student2Bean")
public class Student2 {

    private String id;

    @Lookup
    public SchoolNotification2 getNotification(String name) {
        return null;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
