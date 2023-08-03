package com.design.strategy;

/**
 * @author Prasenjit Kumar Das
 */
public class PassengerVehicle extends Vehicle {
    public PassengerVehicle() {
        super(new NormalDriveStrategy());
    }
}
