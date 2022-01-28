package com.jskno.taskmanagement.sandbox.injectingCollections.generictypes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ResolvableType;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleService {

    @Autowired
    private List<Vehicle> vehicles;

    @Autowired
    @FourWheelsQualifier
    private List<Vehicle> fourWheelsvehicles;

    @Autowired
    private List<Car> cars;

    public void printList() throws NoSuchFieldException {
        System.out.println("VEHICLES");
        vehicles.stream().forEach(vehicle -> System.out.println(vehicle));
        System.out.println("FOUR WHEELS VEHICLES");
        fourWheelsvehicles.stream().forEach(fourWheelsvehicle -> System.out.println(fourWheelsvehicle));
        System.out.println("CARS");
        cars.stream().forEach(car -> System.out.println(car));

        System.out.println("GENERICS STUFF");
        ResolvableType vehiclesType = ResolvableType.forField(getClass().getDeclaredField("vehicles"));
        System.out.println(vehiclesType);

        ResolvableType type = vehiclesType.getGeneric();
        System.out.println(type);

        Class<?> aClass = type.resolve();
        System.out.println(aClass);
    }

}
