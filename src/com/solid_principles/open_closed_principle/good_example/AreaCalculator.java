package com.solid_principles.open_closed_principle.good_example;

public class AreaCalculator {
    public double calculateArea(Shape shape) {
        return shape.calculateArea(); // No modification needed for new shapes
    }
}
