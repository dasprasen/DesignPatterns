package com.solid_principles.liskov_substitution.good_example;

public class Sparrow implements FlyingBird {
    @Override
    public void fly() {
        System.out.println("sparrow flying..");
    }

    @Override
    public void eat() {
        System.out.println("sparrow eating..");
    }
}
