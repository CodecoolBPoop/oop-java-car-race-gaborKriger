package com.codecool.car_race;

import java.util.Random;

public class Car extends Vehicle implements PrepareForLap {

    public Car() {
        String[] names = new String[]{
                "Vision", "Intro", "Moonlight", "Vanish", "Bullet",
                "Voyage", "Enigma", "Vagabond", "Ivory", "Deputy",
                "Titan", "Obsidian", "Albatross", "Mastery", "Spire",
                "Heirloom", "Dawn", "Olympian", "Inception", "Essence",
                "Meridian", "Blast", "Freedom", "Cobra", "Daydream",
                "Specter", "Onyx", "Magic", "Bullet", "Grit",
                "Reflect", "Onyx", "Alabaster", "Zeal", "Dawn",
                "Desire", "Icon", "Evolution", "Quest", "Lightning"};

        int firstNameIndex = new Random().nextInt(names.length);
        int lastNameIndex = new Random().nextInt(names.length);
        setName(names[firstNameIndex] + " " + names[lastNameIndex]);
    }

    @Override
    public void prepareForLap(Race race) {

    }
}
