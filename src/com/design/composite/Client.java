package com.design.composite;

/**
 * @author Prasenjit Kumar Das
 */
public class Client {
    public static void main(String[] args) {
        CompositeAccount compositeAccount = new CompositeAccount();
        compositeAccount.addAccount(new DepositAccount("DA001", 1000));
        compositeAccount.addAccount(new DepositAccount("DA002", 2000));
        compositeAccount.addAccount(new SavingsAccount("SA001", 1000));

        float totalBalance = compositeAccount.getBalance();
        System.out.println("Total Balance: "+totalBalance);
    }
}
