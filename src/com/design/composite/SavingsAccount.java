package com.design.composite;

/**
 * @author Prasenjit Kumar Das
 */
public class SavingsAccount extends Account {
    private final String accountNo;
    private final float accountBalance;

    public SavingsAccount(String accountNo, float accountBalance) {
        super();
        this.accountNo = accountNo;
        this.accountBalance = accountBalance;
    }

    @Override
    public float getBalance() {
        return accountBalance;
    }
}
