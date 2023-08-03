package com.design.prototype;

/**
 * @author Prasenjit Kumar Das
 */
public class BlueColor extends Color {

    public BlueColor() {
        this.colorName = "blue";
    }

    @Override
    void addColor() {
        System.out.println("Blue color added");
    }
}
