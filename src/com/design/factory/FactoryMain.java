package com.design.factory;

/**
 * @author Prasenjit Kumar Das
 */
public class FactoryMain {
    public static void main(String[] args) {
        Vehicle car = VehicleFactory.getInstance("car",4);
        System.out.println(car.getWheel());

        Vehicle bike = VehicleFactory.getInstance("bike",4);
        System.out.println(bike.getWheel());
    }
}
