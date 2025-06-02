package com.solid_principles.liskov_substitution.good_example;

public class Penguin implements Bird {
    @Override
    public void eat() {
        System.out.println("penguin eating");
    }
}
