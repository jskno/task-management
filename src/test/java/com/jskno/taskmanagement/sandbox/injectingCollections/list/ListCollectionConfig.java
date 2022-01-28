package com.jskno.taskmanagement.sandbox.injectingCollections.list;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

@Configuration
public class ListCollectionConfig {

    @Bean
    public ListCollectionsBean listCollectionsBean() {
        return new ListCollectionsBean();
    }

    @Bean
    public List<String> nameList() {
        return Arrays.asList("John", "Adam", "Jose");
    }
}
