package com.design.payment_gateway_lld;

import java.util.Map;
import java.util.UUID;

public class Transaction {
    private String id;
    private String clientName;
    private double amount;
    private PaymentMethodType paymentMethodType;
    private Map<String, String> paymentDetails;
    private TransactionStatus status;
    private String bankName;

    public Transaction(String clientName, double amount, PaymentMethodType paymentMethodType, Map<String, String> paymentDetails) {
        this.id = UUID.randomUUID().toString();
        this.clientName = clientName;
        this.amount = amount;
        this.paymentMethodType = paymentMethodType;
        this.paymentDetails = paymentDetails;
        this.status = TransactionStatus.PENDING;
    }

    public void setStatus(TransactionStatus status) {
        this.status = status;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getId() {
        return id;
    }

    public String getClientName() {
        return clientName;
    }

    public double getAmount() {
        return amount;
    }

    public PaymentMethodType getPaymentMethodType() {
        return paymentMethodType;
    }

    public Map<String, String> getPaymentDetails() {
        return paymentDetails;
    }

    public TransactionStatus getStatus() {
        return status;
    }

    public String getBankName() {
        return bankName;
    }
}
