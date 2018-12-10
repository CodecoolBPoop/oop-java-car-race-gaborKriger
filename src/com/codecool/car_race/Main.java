package com.codecool.car_race;


public class Main {

    /**
     * Creates all the vehicles that will be part of this race.
     */
    private static void createVehicles(Race race) {
    }

    /**
     * Entry point of our program. Creates one race instance and
     * uses that.
     * <p>
     *
     * @param args commandline arguments passed to the program.
     *             It is unused.
     */
    public static void main(String[] args) {
        Race race = new Race();
        createVehicles(race);

        race.simulateRace();
        race.printRaceResults();

        test();
    }

    private static void test() {
        for (int i = 0; i < 10; i++) {
            Car car = new Car();
            System.out.println("||Test|| car name: " + car.getName());
        }

        System.out.println();

        for (int i = 0; i < 10; i++) {
            Motorcycle motor = new Motorcycle();
            System.out.println("||Test|| motor name: " + motor.getName());
        }

        System.out.println();

        for (int i = 0; i < 10; i++) {
            Truck truck = new Truck();
            System.out.println("||Test|| truck name: " + truck.getName());
        }

        System.out.println();
    }
}
