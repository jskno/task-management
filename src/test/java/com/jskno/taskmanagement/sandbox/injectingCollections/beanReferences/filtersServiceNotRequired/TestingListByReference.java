package com.jskno.taskmanagement.sandbox.injectingCollections.beanReferences.filtersServiceNotRequired;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestingListByReference {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(FilterConfigNotRequired.class);
        FilterClientNotRequired filterClient = context.getBean(FilterClientNotRequired.class);
        filterClient.listFilters();
    }


}
