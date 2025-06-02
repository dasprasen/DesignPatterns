package com.solid_principles.liskov_substitution.bad_example;

public class BirdHandler {

    public static void makeBirdFly(Bird bird) {
        bird.fly();
    }

    public static void main(String[] args) {
        Bird flyingBird = new Bird();
        Bird ostrich = new Penguin();

        makeBirdFly(flyingBird);  // Works fine
        makeBirdFly(ostrich);      // Throws exception -> breaks LSP!
    }
}
