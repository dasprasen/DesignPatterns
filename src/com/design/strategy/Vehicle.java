package com.design.strategy;

/**
 * @author Prasenjit Kumar Das
 */
public class Vehicle {

    VehicleStrategy vehicleStrategy;

    public Vehicle(VehicleStrategy vehicleStrategy) {
        this.vehicleStrategy = vehicleStrategy;
    }

    public void drive() {
        vehicleStrategy.drive();
    }
}
