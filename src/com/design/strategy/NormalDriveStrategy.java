package com.design.strategy;

/**
 * @author Prasenjit Kumar Das
 */
public class NormalDriveStrategy implements VehicleStrategy {
    @Override
    public void drive() {
        System.out.println("Normal functionality..");
    }
}
