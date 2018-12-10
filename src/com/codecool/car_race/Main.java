package com.codecool.car_race;


import java.util.ArrayList;
import java.util.List;

public class Main {
    static List<Vehicle> vehicles = new ArrayList<>();

    /**
     * Creates all the vehicles that will be part of this race.
     */
    private static void createVehicles() {
        for (int i = 0; i < 10; i++) {
            Car car = new Car();
            vehicles.add(car);
            Motorcycle motorcycle = new Motorcycle();
            vehicles.add(motorcycle);
            Truck truck = new Truck();
            vehicles.add(truck);
        }
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
        createVehicles();

        race.simulateRace();
        race.printRaceResults();

        //constructorTest();
        //vehicleTest();
    }

    private static void constructorTest() {
        for (int i = 0; i < 10; i++) {
            Car car = new Car();
            System.out.print("||Test|| car name: " + car.getName());
            System.out.println(" == speed: " + car.getNormalSpeed() + "km/h");
        }

        System.out.println();

        for (int i = 0; i < 10; i++) {
            Motorcycle motor = new Motorcycle();
            System.out.print("||Test|| motor name: " + motor.getName());
            System.out.println(" == speed: " + motor.getNormalSpeed() + "km/h");
        }

        System.out.println();

        for (int i = 0; i < 10; i++) {
            Truck truck = new Truck();
            System.out.print("||Test|| truck name: " + truck.getName());
            System.out.println(" == speed: " + truck.getNormalSpeed() + "km/h");
        }

        System.out.println();
    }

    private static void vehicleTest() {
        for (Vehicle vehicle : vehicles) {
            System.out.print("||Test|| Name: " + vehicle.getName());
            System.out.println(" == speed: " + vehicle.getNormalSpeed() + "km/h");
        }
    }
}
