package com.jskno.taskmanagement.sandbox.injectingCollections.generictypes;

public abstract class Vehicle {

    private String name;
    private String manufacter;

    public Vehicle(String name, String manufacter) {
        this.name = name;
        this.manufacter = manufacter;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManufacter() {
        return manufacter;
    }

    public void setManufacter(String manufacter) {
        this.manufacter = manufacter;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "name='" + name + '\'' +
                ", manufacter='" + manufacter + '\'' +
                '}';
    }
}
