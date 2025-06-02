package com.design.splitwise_lld;

public class EqualSplit implements Split {
    private User user;
    private double amount;

    public EqualSplit(User user, double amount) {
        this.user = user;
        this.amount = amount;
    }

    @Override
    public User getUser() {
        return user;
    }

    @Override
    public double getAmount() {
        return amount;
    }
}
