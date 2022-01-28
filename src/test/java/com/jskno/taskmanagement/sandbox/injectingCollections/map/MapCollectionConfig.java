package com.jskno.taskmanagement.sandbox.injectingCollections.map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class MapCollectionConfig {

    @Bean
    public MapCollectionsBean mapCollectionsBean() {
        return new MapCollectionsBean();
    }

    @Bean
    public Map<Integer, String> namesMap() {
        Map<Integer, String> namesMap = new HashMap<>();
        namesMap.put(1, "John");
        namesMap.put(2, "Raquel");
        namesMap.put(3, "Alvaro");
        namesMap.put(4, "Jose");
        return namesMap;
    }
}
