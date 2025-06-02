package com.solid_principles.interface_segregation.bad_example;

public class RobotWorker implements Worker {
    @Override
    public void work() {
        System.out.println("Robot working...");
    }

    @Override
    public void eat() {
        // Robots don't eat, but they are forced to implement this!
        throw new UnsupportedOperationException("Robots don't eat!");
    }
}
