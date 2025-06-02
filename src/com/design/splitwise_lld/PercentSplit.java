package com.design.splitwise_lld;

public class PercentSplit implements Split {
    private User user;
    private double amount;
    private double percentage;

    public PercentSplit(User user, double amount, double percentage) {
        this.user = user;
        this.amount = amount;
        this.percentage = percentage;
    }

    @Override
    public User getUser() {
        return user;
    }

    @Override
    public double getAmount() {
        return amount;
    }

    public double getPercentage() {
        return percentage;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }
}
