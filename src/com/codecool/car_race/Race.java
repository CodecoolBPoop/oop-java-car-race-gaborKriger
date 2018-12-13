package com.codecool.car_race;

import java.util.Comparator;

import static com.codecool.car_race.Main.vehicles;

class Race {

    void simulateRace() {
        for (int i = 0; i < 50; i++) {
            for (Vehicle vehicle : vehicles) {
                if (vehicle instanceof Car) {
                    ((Car) vehicle).prepareForLap();
                    moveForAnHour(vehicle);
                }
                if (vehicle instanceof Motorcycle) {
                    ((Motorcycle) vehicle).prepareForLap();
                    moveForAnHour(vehicle);
                }
                if (vehicle instanceof Truck) {
                    ((Truck) vehicle).prepareForLap();
                    moveForAnHour(vehicle);
                }
            }
            printMomentaryPosition(i);
        }
        System.out.println();
    }

    private void moveForAnHour(Vehicle vehicle) {
        int traveled = vehicle.getNormalSpeed();
        vehicle.setDistanceTraveled(traveled);
    }

    private void printMomentaryPosition(int i) {
        vehicles.sort(Comparator.comparing(Vehicle::getDistanceTraveled).reversed());

        Vehicle first = vehicles.get(0);

        String type = "";

        if (first instanceof Car) {
            type = "car";
        }
        if (first instanceof Motorcycle) {
            type = "motorcycle";
        }
        if (first instanceof Truck) {
            type = "truck";
        }
        System.out.println(i + "round "
                            + "1st (" + type + "), name: "
                            + first.getName()
                            + " traveled: " + first.getDistanceTraveled() + "km");
    }

    void printRaceResults() {
        vehicles.sort(Comparator.comparing(Vehicle::getDistanceTraveled).reversed());

        int place = 1;
        for (Vehicle vehicle : vehicles) {
            if (vehicle instanceof Car) {
                System.out.println(place + " was car, name: \t"
                        + vehicle.getName() + " traveled: \t"
                        + vehicle.getDistanceTraveled() + " km");
            }
            if (vehicle instanceof Motorcycle) {
                System.out.println(place + " was motor, name: \t"
                        + vehicle.getName() + " traveled: \t"
                        + vehicle.getDistanceTraveled() + " km");
            }
            if (vehicle instanceof Truck) {
                System.out.println(place + " was truck, name: \t"
                        + vehicle.getName() + " traveled: \t"
                        + vehicle.getDistanceTraveled() + " km");
            }
            place++;
        }
    }
}
