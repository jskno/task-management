package com.jskno.taskmanagement.sandbox.injectingCollections.set;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestingCollection {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(SetCollectionConfig.class);
        SetCollectionsBean collectionsBean = context.getBean(SetCollectionsBean.class);
        collectionsBean.printNameSet();
    }
}
