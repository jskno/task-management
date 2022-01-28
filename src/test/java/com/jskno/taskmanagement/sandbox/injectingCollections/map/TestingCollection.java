package com.jskno.taskmanagement.sandbox.injectingCollections.map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestingCollection {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(MapCollectionConfig.class);
        MapCollectionsBean collectionsBean = context.getBean(MapCollectionsBean.class);
        collectionsBean.printNamesMap();
    }
}
