package com.design.bridge;

/**
 * @author Prasenjit Kumar Das
 */
public class NewRemote implements Remote {
    @Override
    public void on() {
        System.out.println("On with NewRemote");
    }

    @Override
    public void off() {
        System.out.println("Off with NewRemote");
    }
}
