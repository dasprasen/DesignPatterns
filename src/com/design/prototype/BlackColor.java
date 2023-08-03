package com.design.prototype;

/**
 * @author Prasenjit Kumar Das
 */
public class BlackColor extends Color {

    public BlackColor() {
        this.colorName = "black";
    }

    @Override
    void addColor() {
        System.out.println("Black color added");
    }
}
