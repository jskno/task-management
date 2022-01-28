package com.jskno.taskmanagement.sandbox.injectingCollections.list;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestingCollection {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ListCollectionConfig.class);
        ListCollectionsBean collectionsBean = context.getBean(ListCollectionsBean.class);
        collectionsBean.printNameList();
    }
}
