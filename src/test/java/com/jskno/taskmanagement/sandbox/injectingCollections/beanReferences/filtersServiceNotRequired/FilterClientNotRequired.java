package com.jskno.taskmanagement.sandbox.injectingCollections.beanReferences.filtersServiceNotRequired;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class FilterClientNotRequired {

    @Autowired(required = false)
    private List<FilterServiceNotRequired> filters = new ArrayList<>();


    public void listFilters() {
        filters.stream().forEach(filterService -> System.out.println(filterService.getClass().getName()));
    }
}
