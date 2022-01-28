package com.jskno.taskmanagement.sandbox.injectingCollections.set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.HashSet;

@Configuration
public class SetCollectionConfig {

    @Bean
    public SetCollectionsBean setCollectionsBean() {
        return new SetCollectionsBean(new HashSet<>(Arrays.asList("John", "Adam", "Harry")));
    }
}
