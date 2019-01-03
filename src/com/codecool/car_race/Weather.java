package com.codecool.car_race;

import com.codecool.car_race.util.MyRandom;

/**
 * A class representing the weather. Advances its state by each call
 * to {@link Weather#advance()}.
 */
public class Weather {
    /**
     * Chance that it will rain in a new time-step.
     */
    private static final int CHANCE_OF_RAIN = 30;

    /**
     * State of rain.
     */
    private boolean isRaining = false;

    /**
     * Get the state of the rain in the constructor
     */
    public Weather() { advance(); }

    /**
     * Whether it is raining in the current time-step.
     *
     * @return true if it is raining.
     */
    public boolean isRaining() {
        return isRaining;
    }

    /**
     * Calculate the new state of the weather.
     */
    public void advance() {
        isRaining = MyRandom.eventWithChance(CHANCE_OF_RAIN);
    }
}
