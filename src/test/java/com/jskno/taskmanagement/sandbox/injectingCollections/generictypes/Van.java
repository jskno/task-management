package com.jskno.taskmanagement.sandbox.injectingCollections.generictypes;

public class Van extends Vehicle {

    private Integer maxWeight;

    public Van(String name, String manufacter, Integer maxWeight) {
        super(name, manufacter);
        this.maxWeight = maxWeight;
    }

    public Integer getMaxWeight() {
        return maxWeight;
    }

    public void setMaxWeight(Integer maxWeight) {
        this.maxWeight = maxWeight;
    }
}
