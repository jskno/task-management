package com.jskno.taskmanagement.sandbox.injectingCollections.beanReferences.filtersService;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestingListByReference {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(FilterConfig.class);
        FilterClient filterClient = context.getBean(FilterClient.class);
        filterClient.listFilters();
    }


}
