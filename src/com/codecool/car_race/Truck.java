package com.codecool.car_race;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Truck extends Vehicle implements PrepareForLap {

    private final int NORMAL_SPEED = 100;

    private int breakdownTurnsLeft;
    private final static List<Integer> names = new ArrayList<>();

    public Truck() {
        setTruckName();
        setNormalSpeed(NORMAL_SPEED);
    }

    private void setTruckName() {
        Random random = new Random();
        boolean checkName = true;
        while (checkName) {
            int nameIndex = random.nextInt(1001);
            if (!names.contains(nameIndex)) {
                names.add(nameIndex);
                setName(String.valueOf(nameIndex));
                checkName = false;
            }
        }
    }

    public int getBreakdownTurnsLeft() {
        return breakdownTurnsLeft;
    }

    private void breakdownTurnsLeft() {
        Random random = new Random();
        int breakDown = random.nextInt(101);
        if (breakDown <= 5) {
            this.breakdownTurnsLeft = 2;
        }
    }

    private void changeTruckSpeed() {
        if (breakdownTurnsLeft > 0) {
            setNormalSpeed(0);
            breakdownTurnsLeft--;
        }
    }

    @Override
    public void prepareForLap() {
        if (getBreakdownTurnsLeft() > 0) {
            changeTruckSpeed();
        } else {
            breakdownTurnsLeft();
        }
    }
}