package com.codecool.car_race;

public class Motorcycle extends Vehicle implements PrepareForLap {

    private final int NORMAL_SPEED = 100;
    private static int objectCount;

    public Motorcycle() {
        objectCount++;
        setName("Motorcycle " + objectCount);
        setNormalSpeed(NORMAL_SPEED);
    }

    @Override
    public void prepareForLap(Race race) {

    }
}
