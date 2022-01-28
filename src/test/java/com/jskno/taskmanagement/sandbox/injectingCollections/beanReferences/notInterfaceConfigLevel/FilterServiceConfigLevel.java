package com.jskno.taskmanagement.sandbox.injectingCollections.beanReferences.notInterfaceConfigLevel;

public class FilterServiceConfigLevel {

    private String name;

    public FilterServiceConfigLevel(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
