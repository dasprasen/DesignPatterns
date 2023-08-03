package com.design.chainOfResponsibility;

/**
 * @author Prasenjit Kumar Das
 */
public class Numbers {
    private final int num1;
    private final int num2;

    private final String calculationNeeded;

    public Numbers(int num1, int num2, String calculationNeeded) {
        this.num1 = num1;
        this.num2 = num2;
        this.calculationNeeded = calculationNeeded;
    }

    public int getNum1() {
        return num1;
    }

    public int getNum2() {
        return num2;
    }

    public String getCalculationNeeded() {
        return calculationNeeded;
    }
}
