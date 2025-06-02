package com.solid_principles.interface_segregation.bad_example;

public class HumanWorker implements Worker {
    @Override
    public void work() {
        System.out.println("human is working");
    }

    @Override
    public void eat() {
        System.out.println("human is eating");
    }
}
