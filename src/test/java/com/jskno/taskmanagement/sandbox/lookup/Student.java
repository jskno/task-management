package com.jskno.taskmanagement.sandbox.lookup;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Student {

    private Integer id;
    private String name;
    private List<Calification> califications = new ArrayList<>();

    public Student(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public void addCalification(String subjectName, String mark, LocalDateTime timeStamp) {
        califications.add(new Calification(subjectName, mark, timeStamp));
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", califications=" + califications.stream().map(Calification::toString).collect(Collectors.joining()) +
                '}';
    }

    private class Calification {
        private final String subjectName;
        private final String mark;
        private final LocalDateTime timeStamp;

        public Calification(String subjectName, String mark, LocalDateTime timeStamp) {
            this.subjectName = subjectName;
            this.mark = mark;
            this.timeStamp = timeStamp;
        }

        @Override
        public String toString() {
            return "Calification{" +
                    "subjectName='" + subjectName + '\'' +
                    ", mark='" + mark + '\'' +
                    ", timeStamp=" + timeStamp +
                    '}';
        }
    }


}
