package com.design.abstractfactory;

/**
 * @author Prasenjit Kumar Das
 */
public class Square implements Shape {
    @Override
    public void draw() {
        System.out.println("Inside Square::draw() method.");
    }
}
