package com.design.chainOfResponsibility;

/**
 * @author Prasenjit Kumar Das
 */
public class TestCalChain {
    public static void main(String[] args) {
        Chain chainCalc1 = new AddNumbers();
        Chain chainCalc2 = new SubstractNumbers();

        chainCalc1.setNextChain(chainCalc2);
        Numbers request = new Numbers(4, 2, "add");
        chainCalc1.calculate(request);

        Numbers request2 = new Numbers(4, 2, "sub");
        chainCalc1.calculate(request2);
    }
}
