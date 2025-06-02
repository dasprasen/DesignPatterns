package com.solid_principles.open_closed_principle.bad_example;

// Software entities should be open for extension but closed for modification.
// You should be able to add new functionality without changing existing code.
public class AreaCalculator {
    public double calculateArea(Object shape) {
        if (shape instanceof Rectangle) {
            Rectangle rectangle = (Rectangle) shape;
            return rectangle.width * rectangle.height;
        } else if (shape instanceof Circle) {
            Circle circle = (Circle) shape;
            return Math.PI * circle.radius * circle.radius;
        }
        // Adding new shape requires modifying this method
        return 0;
    }
}
