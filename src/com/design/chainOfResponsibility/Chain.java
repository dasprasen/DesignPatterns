package com.design.chainOfResponsibility;

/**
 * @author Prasenjit Kumar Das
 */
public interface Chain {
    public void setNextChain(Chain nextChain);

    public void calculate(Numbers request);
}
