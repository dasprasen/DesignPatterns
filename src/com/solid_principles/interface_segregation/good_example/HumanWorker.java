package com.solid_principles.interface_segregation.good_example;

public class HumanWorker implements Workable, Eatable {
    @Override
    public void eat() {
        System.out.println("human eating");
    }

    @Override
    public void work() {
        System.out.println("human working");
    }
}
