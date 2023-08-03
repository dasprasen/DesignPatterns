package com.design.decorator;

/**
 * @author Prasenjit Kumar Das
 */
public class BasicDress implements Dress {
    @Override
    public void assemble() {
        System.out.println("Basic Dress Features");
    }
}
