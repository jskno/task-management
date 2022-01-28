package com.jskno.taskmanagement.sandbox.injectingCollections.beanReferences.filtersService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class FilterClient {

    @Autowired
    private List<FilterService> filters = new ArrayList<>();

    @Autowired
    @Qualifier("inclusived")
    private List<FilterService> inclusivedFilters = new ArrayList<>();

    public void listFilters() {
        System.out.println("FILTERS");
        filters.stream().forEach(filterService -> System.out.println(filterService.getClass().getName()));
        System.out.println("INCLUSIVED FILTERS");
        inclusivedFilters.stream().forEach(filterService -> System.out.println(filterService.getClass().getName()));
    }
}
