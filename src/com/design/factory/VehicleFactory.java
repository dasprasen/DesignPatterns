package com.design.factory;

/**
 * @author Prasenjit Kumar Das
 */
public class VehicleFactory {
    public static Vehicle getInstance(String type, int wheel) {
        if(type.equals("null") || type.isEmpty()){
            return null;
        }
        switch (type){
            case "car":
                return new Car(wheel);
            case "bike":
                return new Bike(wheel);
            default:
                throw new IllegalArgumentException("Unknown Vehicle Type "+type);
        }
    }
}
