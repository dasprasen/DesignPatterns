package com.design.strategy;

/**
 * @author Prasenjit Kumar Das
 */
public class SpecialDriveStrategy implements VehicleStrategy {
    @Override
    public void drive() {
        System.out.println("Special functionality..");
    }
}
