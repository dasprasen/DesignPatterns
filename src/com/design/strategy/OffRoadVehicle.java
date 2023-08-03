package com.design.strategy;

/**
 * @author Prasenjit Kumar Das
 */
public class OffRoadVehicle extends Vehicle {
    public OffRoadVehicle() {
        super(new SpecialDriveStrategy());
    }
}
