package com.codecool.car_race;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Truck extends Vehicle implements PrepareForLap {

    private final static List<Integer> names = new ArrayList<>();

    public Truck() {
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

    @Override
    public void prepareForLap(Race race) {

    }
}