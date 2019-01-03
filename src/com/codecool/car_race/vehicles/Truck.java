package com.codecool.car_race.vehicles;

import com.codecool.car_race.Race;
import com.codecool.car_race.util.MyRandom;


/**
 * Trucks are real powerhouses but the intricate machines are prone to
 * failure.
 */
public class Truck extends Vehicle {
    /**
     * Trucks go with a steady 100 km/h.
     */
    private static final int NORMAL_SPEED = 100;

    /**
     * There's a five percent chance a truck will break down.
     */
    private static final int BREAKDOWN_CHANCE = 5;

    /**
     * If a truck breaks down, fixing it takes two turns
     */
    private static final int TURNS_NEEDED_TO_FIX_TRUCK = 2;

    /**
     * Trucks start out in an operational state.
     */
    private State state = State.OPERATIONAL;

    /**
     * When a truck breaks down we need to count the turns spent with fixing
     */
    private int breakdownTurnsLeft;

    /**
     * Create a truck. Name is a random number and the normal speed is a constant number
     */
    public Truck() {
        super(NORMAL_SPEED);
    }

    /**
     * Generate name by converting a random integer to string
     *
     * @return the name of the truck
     */
    @Override
    protected String generateName() {
        return Integer.toString(MyRandom.nextInt(1001));
    }

    /**
     * Calculate the actual speed and also advance the state of the
     * truck.
     * <p>
     */
    @Override
    public void prepareForLap(Race race) {
        if (isBrokenDown()) actualSpeed = 0;
        else actualSpeed = NORMAL_SPEED;

        // change state after setting the speed so it becomes active only from the next turn
        state = nextState();
    }

    /**
     * Determine whether this truck is operational.
     *
     * @return true if this truck is broken down.
     */
    public boolean isBrokenDown() {
        return state != State.OPERATIONAL;
    }

    /**
     * A state machine implementation.
     *
     * @return the state following this state.
     */
    private State nextState() {
        switch(state) {
            case OPERATIONAL:
                if(MyRandom.eventWithChance(BREAKDOWN_CHANCE)) {
                    breakdownTurnsLeft = TURNS_NEEDED_TO_FIX_TRUCK;
                    return State.BROKEN_DOWN;
                }
                break;
            case BROKEN_DOWN:
                if(breakdownTurnsLeft-- > 0) return State.BROKEN_DOWN;
                break;
        }
        return State.OPERATIONAL;
    }

    /**
     * Possible states a truck can be in.
     * <p>
     * Notice that it is embedded inside the truck class.
     */
    private enum State {
        OPERATIONAL,
        BROKEN_DOWN
    }
}
