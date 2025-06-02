package com.design.payment_gateway_lld;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

public class Bank {
    private String name;
    private Set<PaymentMethodType> supportedPaymentMethods;

    public Bank(String name) {
        this.name = name;
        this.supportedPaymentMethods = new HashSet<>();
    }

    public void addSupportForPaymentMethod(PaymentMethodType type) {
        supportedPaymentMethods.add(type);
    }

    public boolean supportsPaymentMethod(PaymentMethodType type) {
        return supportedPaymentMethods.contains(type);
    }

    public TransactionStatus processPayment(Transaction transaction) {
        if (!supportsPaymentMethod(transaction.getPaymentMethodType())) {
            return TransactionStatus.FAILURE;
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return ThreadLocalRandom.current().nextInt(10) < 7 ? TransactionStatus.SUCCESS : TransactionStatus.FAILURE;
    }

    public String getName() {
        return name;
    }

    public Set<PaymentMethodType> getSupportedPaymentMethods() {
        return supportedPaymentMethods;
    }
}
