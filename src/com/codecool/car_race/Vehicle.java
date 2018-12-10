package com.codecool.car_race;

public abstract class Vehicle {
    private String name;
    private int normalSpeed;
    private int distanceTraveled;

    String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    int getNormalSpeed() {
        return normalSpeed;
    }

    void setNormalSpeed(int normalSpeed) {
        this.normalSpeed = normalSpeed;
    }

    public int getDistanceTraveled() {
        return distanceTraveled;
    }

    void setDistanceTraveled(int traveled) {
        this.distanceTraveled += traveled;
    }
}
