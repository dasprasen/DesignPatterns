package com.design.strategy;

import java.util.UUID;

/**
 * @author Prasenjit Kumar Das
 */
public class Main {
    public static void main(String[] args) {
        UUID uuid = UUID.randomUUID();
        System.out.println(uuid);
        Vehicle vehicle = new SportsVehicle();
        vehicle.drive();
    }
}
