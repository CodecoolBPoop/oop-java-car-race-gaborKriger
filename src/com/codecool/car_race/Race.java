package com.codecool.car_race;

import java.util.List;
import java.util.LinkedList;

import com.codecool.car_race.vehicles.Vehicle;
import com.codecool.car_race.vehicles.Car;
import com.codecool.car_race.vehicles.Motorcycle;
import com.codecool.car_race.vehicles.Truck;

/**
 * This class handles a race. It is a class with its own logic and responsibilities.
 * So we have to implement it in a way that we can have multiple races at the same time
 * if we wanted to.
 */
public class Race {
    static final int NUM_OF_LAPS = 50;
    /**
     * Weather can be different for races ongoing parallel so each race has a weather
     */
    private Weather weather = new Weather();

    /**
     * Store if there is a broken truck on the track. This boolean gets updated every turn
     */
    private boolean brokenTruck;

    /**
     * All the vehicles participating in the given race.
     */
    private final List<Vehicle> vehicles = new LinkedList<>();

    /**
     * Returns if there is a broken truck on the track based on the brokenTruck field
     * @return true if there are any trucks that are broken down.
     */
    public boolean isThereABrokenTruck() {
        return brokenTruck;
    }

    /**
     * A proxy method for checking the weather through the Race object.
     *
     * @return true if it is raining.
     * @see Vehicle
     */
    public boolean isRaining() {
        return weather.isRaining();
    }

    /**
     * add a racer to the race
     * @param racer the vehicle we want to add as a racer
     */
    public void registerRacer(Vehicle racer) { vehicles.add(racer); }

    /**
     * Simulates the passing of time by advancing the weather and
     * moving the vehicles for the duration of a whole race.
     */
    public void simulateRace() {
        for (int i = 0; i < NUM_OF_LAPS; i++) {
            for (Vehicle vehicle : vehicles) {
                vehicle.prepareForLap(this);
                vehicle.moveForAnHour();
            }

            // change weather and update broken truck status after the movement done
            weather.advance();
            brokenTruck = getBrokenTruckStatus();
        }
    }

    /**
     * Update broken truck status through this method only
     * @return true if there is broken down truck on the track
     */
    private boolean getBrokenTruckStatus() {
        for (Vehicle vehicle : vehicles) {
            if (vehicle instanceof Truck) {
                Truck truck = (Truck) vehicle;
                if (truck.isBrokenDown()) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Alternative implementation of {@link Race#getBrokenTruckStatus()}
     * using the stream API.
     *
     * @return true if there are any trucks that are broken down.
     */
    public boolean getBrokenTruckStatusWithStreams() {
        return vehicles.parallelStream()
                .filter(v -> v instanceof Truck)
                .map(v -> (Truck)v)
                .anyMatch(Truck::isBrokenDown);
    }

    /**
     * Prints the state of all vehicles. Called at the end of the
     * race.
     */
    public void printRaceResults() {
        vehicles.forEach(System.out::println);
    }
}
