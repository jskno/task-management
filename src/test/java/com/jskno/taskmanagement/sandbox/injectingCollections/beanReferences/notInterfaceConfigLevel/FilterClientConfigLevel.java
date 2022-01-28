package com.jskno.taskmanagement.sandbox.injectingCollections.beanReferences.notInterfaceConfigLevel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class FilterClientConfigLevel {

    @Autowired(required = false)
    private List<FilterServiceConfigLevel> filters = new ArrayList<>();


    public void listFilters() {
        System.out.println("CLASSES");
        filters.stream().forEach(filterService -> System.out.println(filterService.getClass().getName()));
        System.out.println("NAMES");
        filters.stream().forEach(filterService -> System.out.println(filterService.getName()));
    }
}
