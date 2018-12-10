package com.codecool.car_race;

public class Motorcycle extends Vehicle implements PrepareForLap, MoveForAnHour {
    private boolean rain;

    public boolean isRain() {
        return rain;
    }

    public void setRain(boolean rain) {
        this.rain = rain;
    }

    @Override
    public void prepareForLap(Race race) {

    }

    @Override
    public void moveForAnHour() {

    }
}
