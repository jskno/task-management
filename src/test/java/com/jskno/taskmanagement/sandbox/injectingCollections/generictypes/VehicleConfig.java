package com.jskno.taskmanagement.sandbox.injectingCollections.generictypes;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.jskno.taskmanagement.sandbox.injectingCollections.generictypes"})
public class VehicleConfig {

    @Bean
    @FourWheelsQualifier
    public Car mercedes() {
        return new Car("claseA", "Mercedes", 5);
    }

    @Bean
    @FourWheelsQualifier
    public Car bmw() {
        return new Car("Sport", "BMW", 5);
    }

    @Bean
    @FourWheelsQualifier
    public Car audi() {
        return new Car("A3", "Audi", 5);
    }

    @Bean
    @FourWheelsQualifier
    public Van vito() {
        return new Van("Vito", "Mercedes", 1200);
    }

    @Bean
    @FourWheelsQualifier
    public Van ibizaVan() {
        return new Van("IbizaVan", "Seat", 1000);
    }

    @Bean
    public Motorcycle honda1() {
        return new Motorcycle("1", "Honda", 200);
    }

    @Bean
    public Motorcycle honda2() {
        return new Motorcycle("2", "Honda", 220);
    }


}
