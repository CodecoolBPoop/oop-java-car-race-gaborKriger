package com.codecool.car_race;

import java.util.Random;

public class Weather {
    private boolean isRaining;

    public Weather() {
        Random random = new Random();
        int chanceOfRain = random.nextInt(10) + 1;
        if (chanceOfRain <= 3) {
            setRaining(true);
        } else {
            setRaining(false);
        }
    }

    public boolean isRaining() {
        return isRaining;
    }

    private void setRaining(boolean isRaining) {
        this.isRaining = isRaining;
    }
}
