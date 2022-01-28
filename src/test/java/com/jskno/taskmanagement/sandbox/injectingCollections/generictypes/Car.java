package com.jskno.taskmanagement.sandbox.injectingCollections.generictypes;

public class Car extends Vehicle {

    private Integer numberOfDoors;

    public Car(String name, String manufacter, Integer numberOfDoors) {
        super(name, manufacter);
        this.numberOfDoors = numberOfDoors;
    }

    public Integer getNumberOfDoors() {
        return numberOfDoors;
    }

    public void setNumberOfDoors(Integer numberOfDoors) {
        this.numberOfDoors = numberOfDoors;
    }
}
