package com.design.prototype;

/**
 * @author Prasenjit Kumar Das
 */
public class Prototype {
    public static void main (String[] args)
    {
        ColorStore.getColor("blue").addColor();
        ColorStore.getColor("black").addColor();
        ColorStore.getColor("black").addColor();
        ColorStore.getColor("blue").addColor();
    }
}
