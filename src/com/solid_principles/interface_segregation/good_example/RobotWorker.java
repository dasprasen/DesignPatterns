package com.solid_principles.interface_segregation.good_example;

public class RobotWorker implements Workable {
    @Override
    public void work() {
        System.out.println("robot working");
    }
}
