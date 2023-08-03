package com.design.factory;

/**
 * @author Prasenjit Kumar Das
 */
public class Bike implements Vehicle{
    int wheel;
    Bike(int wheel){
        this.wheel = wheel;
    }
    @Override
    public int getWheel() {
        return this.wheel;
    }
}
