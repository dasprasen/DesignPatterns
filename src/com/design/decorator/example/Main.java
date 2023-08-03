package com.design.decorator.example;

/**
 * @author Prasenjit Kumar Das
 */
public class Main {
    public static void main(String[] args) {
        BasePizza pizza = new Mushroom(new ExtraCheese(new Margherita()));
        System.out.println(pizza.cost());
    }
}
