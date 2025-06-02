package com.design.payment_gateway_lld;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class Router {
    private Map<PaymentMethodType, Map<String, Double>> paymentMethodToDistribute;
    private Map<String, Bank> banks;

    public Router() {
        this.paymentMethodToDistribute = new HashMap<>();
        this.banks = new HashMap<>();
    }

    public void addBank(Bank bank) {
        banks.put(bank.getName(), bank);
    }

    public void setDistribution(PaymentMethodType paymentType, Map<String, Double> distribution) {
        double sum = distribution.values().stream().mapToDouble(Double::doubleValue).sum();
        if(Math.abs(sum - 100.0) > 0.001) {
            throw new IllegalArgumentException("Distribution must sum to 100%");
        }

        for (String bankName : distribution.keySet()) {
            if (!banks.containsKey(bankName)) {
                throw new IllegalArgumentException("Bank " + bankName + " does not exist");
            }
            if (!banks.get(bankName).supportsPaymentMethod(paymentType)) {
                throw new IllegalArgumentException("Bank " + bankName + " does not support " + paymentType);
            }
        }
        paymentMethodToDistribute.put(paymentType, new HashMap<>(distribution));
    }

    public Bank routeTransaction(Transaction transaction) {
        PaymentMethodType paymentMethodType = transaction.getPaymentMethodType();
        if(!paymentMethodToDistribute.containsKey(paymentMethodType)) {
            throw new IllegalStateException("No distribution set for payment method: " + paymentMethodType);
        }

        Map<String, Double> distribution = paymentMethodToDistribute.get(paymentMethodType);
        double randomVal = ThreadLocalRandom.current().nextDouble(100.0);
        double cumulativePercentage = 0.0;

        for(Map.Entry<String, Double> entry : distribution.entrySet()) {
            cumulativePercentage += entry.getValue();
            if (randomVal <= cumulativePercentage) {
                String bankName = entry.getKey();
                Bank selectedBank = banks.get(bankName);
                transaction.setBankName(bankName);
                return selectedBank;
            }
        }
        String firstBankName = distribution.keySet().iterator().next();
        transaction.setBankName(firstBankName);
        return banks.get(firstBankName);
    }

    public Map<PaymentMethodType, Map<String, Double>> getDistribution() {
        return paymentMethodToDistribute;
    }
}
