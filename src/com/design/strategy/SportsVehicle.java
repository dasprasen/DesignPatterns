package com.design.strategy;

/**
 * @author Prasenjit Kumar Das
 */
public class SportsVehicle extends Vehicle {
    public SportsVehicle() {
        super(new SpecialDriveStrategy());
    }
}
