package com.design.decorator.example;

/**
 * @author Prasenjit Kumar Das
 */
public class ExtraCheese extends ToppingsDecorator {

    BasePizza basePizza;

    public ExtraCheese(BasePizza basePizza) {
        this.basePizza = basePizza;
    }

    @Override
    public int cost() {
        return this.basePizza.cost() + 10;
    }
}
