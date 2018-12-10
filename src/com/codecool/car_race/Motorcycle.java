package com.codecool.car_race;

import java.util.Random;

public class Motorcycle extends Vehicle implements PrepareForLap {

    private final int NORMAL_SPEED = 100;
    private final int MINIMUM_SPEED_IN_THE_RAIN = 5;
    private final int MAXIMUM_SPEED_IN_THE_RAIN = 50;

    private static int objectCount;

    public Motorcycle() {
        objectCount++;
        setName("Motorcycle " + objectCount);
        setNormalSpeed(NORMAL_SPEED);
    }

    void changeMotorcycleSpeed() {
        Random random = new Random();
        int speed = random.nextInt(
                (MAXIMUM_SPEED_IN_THE_RAIN - MINIMUM_SPEED_IN_THE_RAIN) + 1)
                + MINIMUM_SPEED_IN_THE_RAIN;
        setNormalSpeed(speed);
    }

    @Override
    public void prepareForLap() {
        Weather weather = new Weather();
        boolean isRaining = weather.isRaining();
        if (isRaining) {
            changeMotorcycleSpeed();
        }
    }
}
