package com.design.strategy_pattern;

public class GooglePayPayment implements PaymentStrategy {
    @Override
    public void pay(int amount) {
        System.out.println("Paid " + amount + " using Google Pay.");
    }
}
