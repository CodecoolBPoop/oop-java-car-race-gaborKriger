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
        }
    }

    private void moveForAnHour(Vehicle vehicle) {
        int traveled = vehicle.getNormalSpeed();
        vehicle.setDistanceTraveled(traveled);
    }

    void printRaceResults() {
        vehicles.sort(Comparator.comparing(Vehicle::getDistanceTraveled).reversed());

        int place = 1;
        for (Vehicle vehicle : vehicles) {
            if (vehicle instanceof Car) {
                System.out.println(place + " was car, name: "
                        + vehicle.getName() + " traveled: "
                        + vehicle.getDistanceTraveled() + " km");
            }
            if (vehicle instanceof Motorcycle) {
                System.out.println(place + " was motor, name: "
                        + vehicle.getName() + " traveled: "
                        + vehicle.getDistanceTraveled() + " km");
            }
            if (vehicle instanceof Truck) {
                System.out.println(place + " was truck, name: "
                        + vehicle.getName() + " traveled: "
                        + vehicle.getDistanceTraveled() + " km");
            }
            place++;
        }
    }
}
