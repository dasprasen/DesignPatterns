package com.design.abstractfactory;

/**
 * @author Prasenjit Kumar Das
 */
public class RoundedRectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Inside RoundedRectangle::draw() method.");
    }
}
