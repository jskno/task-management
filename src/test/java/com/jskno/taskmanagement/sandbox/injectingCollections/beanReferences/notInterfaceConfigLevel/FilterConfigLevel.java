package com.jskno.taskmanagement.sandbox.injectingCollections.beanReferences.notInterfaceConfigLevel;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

@Configuration
@ComponentScan(basePackages = {"com.jskno.taskmanagement.sandbox.injectingCollections.beanReferences.notInterfaceConfigLevel"})
public class FilterConfigLevel {

    @Bean
    @Order(3)
    public FilterServiceConfigLevel weightFilterService() {
        return new FilterServiceConfigLevel("weightFilterService");
    }

    @Bean
    @Order(2)
    public FilterServiceConfigLevel heightFilterService() {
        return new FilterServiceConfigLevel("heightFilterService");
    }

    @Bean
    @Order(1)
    public FilterServiceConfigLevel genreFilterService() {
        return new FilterServiceConfigLevel("genreFilterService");
    }
}
