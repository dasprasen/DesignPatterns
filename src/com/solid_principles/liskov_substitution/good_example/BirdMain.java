package com.solid_principles.liskov_substitution.good_example;

// Objects of a superclass should be replaceable with objects of a subclass without breaking the application.
// Subtypes must be substitutable for their base types.
public class BirdMain {
    public static void main(String[] args) {
        FlyingBird sparrow = new Sparrow();
        sparrow.fly();  // Works fine

        Bird ostrich = new Penguin();
        ostrich.eat();  // Works fine, no need to fly
    }
}
