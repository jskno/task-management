package com.jskno.taskmanagement.sandbox.injectingCollections.generictypes;

public class Motorcycle extends Vehicle {

    private Integer speedLimit;

    public Motorcycle(String name, String manufacter, Integer speedLimit) {
        super(name, manufacter);
        this.speedLimit = speedLimit;
    }

    public Integer getSpeedLimit() {
        return speedLimit;
    }

    public void setSpeedLimit(Integer speedLimit) {
        this.speedLimit = speedLimit;
    }
}
