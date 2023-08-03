package com.design.abstractfactory;

/**
 * @author Prasenjit Kumar Das
 */
public class Rectangle implements Shape {

    @Override
    public void draw() {
        System.out.println("Inside Rectangle::draw() method.");
    }
}
