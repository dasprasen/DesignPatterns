package com.design.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Prasenjit Kumar Das
 */
public class CompositeAccount extends Account {
    private float totalBalance;
    private final List<Account> accountList = new ArrayList<>();

    @Override
    public float getBalance() {
        totalBalance = 0;
        for(Account account : accountList) {
            totalBalance += account.getBalance();
        }
        return totalBalance;
    }

    public void addAccount(Account account) {
        accountList.add(account);
    }

    public void removeAccount(Account account) {
        accountList.remove(account);
    }
}
