package com.jskno.taskmanagement.sandbox.injectingCollections.generictypes;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestingVehicle {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(VehicleConfig.class);
        VehicleService vehicleService = context.getBean(VehicleService.class);
        try {
            vehicleService.printList();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }
}
