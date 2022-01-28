package com.jskno.taskmanagement.sandbox.lookup2;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public abstract class StudentServices2 {

    private Map<String, SchoolNotification2> notes = new HashMap<>();

    @Lookup
    protected abstract SchoolNotification2 getNotification(String name);

    public String appendMark(String name, Integer mark) {
        SchoolNotification2 notification = notes.computeIfAbsent(name, exists -> getNotification(name));
        return notification.addMark(mark);
    }

}
