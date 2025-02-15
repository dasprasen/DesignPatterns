package com.design.strategy_pattern_arithmetic_operation;

/**
 * @author Prasenjit Kumar Das
 */
public class Multiply implements Strategy {
    @Override
    public int doOperation(int num1, int num2) {
        return num1 * num2;
    }
}
