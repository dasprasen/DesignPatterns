package com.design.payment_gateway_lld;

import java.util.HashSet;
import java.util.Set;

public class Client {
    private String name;
    private Set<PaymentMethodType> enabledPaymentMethods;

    public Client(String name) {
        this.name = name;
        this.enabledPaymentMethods = new HashSet<>();
    }

    public void enablePaymentMethod(PaymentMethodType type) {
        enabledPaymentMethods.add(type);
    }

    public void disablePaymentMethod(PaymentMethodType type) {
        enabledPaymentMethods.remove(type);
    }

    public boolean isPaymentMethodEnabled(PaymentMethodType type) {
        return enabledPaymentMethods.contains(type);
    }


    public String getName() {
        return name;
    }

    public Set<PaymentMethodType> getEnabledPaymentMethods() {
        return enabledPaymentMethods;
    }
}
