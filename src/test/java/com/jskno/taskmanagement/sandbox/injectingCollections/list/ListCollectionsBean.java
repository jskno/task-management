package com.jskno.taskmanagement.sandbox.injectingCollections.list;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ListCollectionsBean {

    @Autowired
    private List<String> nameList;

    public void printNameList() {
        System.out.println(nameList);
    }
}
