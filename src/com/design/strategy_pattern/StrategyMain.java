package com.design.strategy_pattern;

public class StrategyMain {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        cart.setPaymentStrategy(new CreditCardPayment());
        cart.checkout(1000);

        cart.setPaymentStrategy(new GooglePayPayment());
        cart.checkout(2000);

        cart.setPaymentStrategy(new PayPalPayment());
        cart.checkout(3000);
    }
}
