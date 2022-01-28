package com.jskno.taskmanagement.sandbox.injectingCollections.beanReferences.notInterfaceConfigLevel;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestingListByReference {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(FilterConfigLevel.class);
        FilterClientConfigLevel filterClient = context.getBean(FilterClientConfigLevel.class);
        filterClient.listFilters();
    }


}
