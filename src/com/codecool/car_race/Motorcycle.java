package com.codecool.car_race;

public class Motorcycle extends Vehicle implements PrepareForLap {

    private static int objectCount;

    public Motorcycle() {
        objectCount++;
        setName("Motorcycle " + objectCount);
    }

    @Override
    public void prepareForLap(Race race) {

    }
}
