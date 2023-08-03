package com.design.bridge;

/**
 * @author Prasenjit Kumar Das
 */
public class OldRemote implements Remote {
    @Override
    public void on() {
        System.out.println("On with Old Remote");
    }

    @Override
    public void off() {
        System.out.println("Off with Old Remote");
    }
}
