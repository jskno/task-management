package com.jskno.taskmanagement.sandbox.injectingCollections.map;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

public class MapCollectionsBean {

    private Map<Integer, String> namesMap;

    @Autowired

    public void setNamesMap(Map<Integer, String> namesMap) {
        this.namesMap = namesMap;
    }

    public void printNamesMap() {
        System.out.println(namesMap);
    }
}
