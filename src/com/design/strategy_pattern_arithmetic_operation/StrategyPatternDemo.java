package com.design.strategy_pattern_arithmetic_operation;

/**
 * @author Prasenjit Kumar Das
 */
public class StrategyPatternDemo {
    public static void main(String[] args) {

        Context context1 = new Context(new Add());
        System.out.println(context1.executeStrategy(2, 5));

        context1 = new Context(new Subtract());
        System.out.println(context1.executeStrategy(10, 4));

        context1 = new Context(new Multiply());
        System.out.println(context1.executeStrategy(2, 3));
    }
}
