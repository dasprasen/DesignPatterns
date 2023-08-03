package com.design.factory;

/**
 * @author Prasenjit Kumar Das
 */
public class Car implements Vehicle {
    int wheel;
    Car(int wheel){
        this.wheel = wheel;
    }
    @Override
    public int getWheel() {
        return this.wheel;
    }
}
