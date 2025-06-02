package com.design.payment_gateway_lld;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class PaymentGateway {
    private Map<String, Client> clients;
    private Map<String, Bank> banks;
    private Set<PaymentMethod> supportedPaymentMethods;
    private Router router;

    public PaymentGateway() {
        this.clients = new HashMap<>();
        this.banks = new HashMap<>();
        this.supportedPaymentMethods = new HashSet<>();
        this.router = new Router();

        for (PaymentMethodType type : PaymentMethodType.values()) {
            supportedPaymentMethods.add(new PaymentMethod(type));
        }
    }

    public void addClient(String clientName) {
        if(clients.containsKey(clientName)) {
            throw new IllegalArgumentException("Client already exists: " + clientName);
        }
        clients.put(clientName, new Client(clientName));
    }

    public void removeClient(String clientName) {
        if (!clients.containsKey(clientName)) {
            throw new IllegalArgumentException("Client does not exist: " + clientName);
        }
        clients.remove(clientName);
    }

    public boolean hasClient(String clientName) {
        return clients.containsKey(clientName);
    }

    public void addBank(String bankName) {
        if (banks.containsKey(bankName)) {
            throw new IllegalArgumentException("Bank already exists: " + bankName);
        }
        Bank bank = new Bank(bankName);
        banks.put(bankName, bank);
        router.addBank(bank);
    }

    public Set<PaymentMethodType> listSupportedPaymentMethods(String clientName) {
        if (clientName != null) {
            if (!clients.containsKey(clientName)) {
                throw new IllegalArgumentException("Client does not exist: " + clientName);
            }
            return clients.get(clientName).getEnabledPaymentMethods();
        } else {
            return supportedPaymentMethods.stream()
                    .map(PaymentMethod::getType)
                    .collect(Collectors.toSet());
        }
    }

    public void addSupportForPaymentMethod(PaymentMethodType type, String clientName, String bankName) {
        if (bankName != null) {
            if (!banks.containsKey(bankName)) {
                throw new IllegalArgumentException("Bank does not exist: " + bankName);
            }
            banks.get(bankName).addSupportForPaymentMethod(type);
        }

        if (clientName != null) {
            if (!clients.containsKey(clientName)) {
                throw new IllegalArgumentException("Client does not exist: " + clientName);
            }
            clients.get(clientName).enablePaymentMethod(type);
        }
    }

    public void removePaymentMethod(PaymentMethodType type, String clientName) {
        if (clientName != null) {
            if (!clients.containsKey(clientName)) {
                throw new IllegalArgumentException("Client does not exist: " + clientName);
            }
            clients.get(clientName).disablePaymentMethod(type);
        }
    }

    public void setDistribution(PaymentMethodType type, Map<String, Double> distribution) {
        router.setDistribution(type, distribution);
    }

    public Map<PaymentMethodType, Map<String, Double>> showDistribution() {
        return router.getDistribution();
    }

    public TransactionStatus makePayment(String clientName, double amount, PaymentMethodType type, Map<String, String> paymentDetails) {
        if (!clients.containsKey(clientName)) {
            throw new IllegalArgumentException("Client does not exist: " + clientName);
        }

        Client client = clients.get(clientName);
        if (!client.isPaymentMethodEnabled(type)) {
            throw new IllegalArgumentException("Payment method not enabled for client: " + type);
        }

        PaymentMethod method = getPaymentMethod(type);
        Set<String> requiredParams = method.getRequiredParams().keySet();
        if (!paymentDetails.keySet().containsAll(requiredParams)) {
            throw new IllegalArgumentException("Missing required payment parameters for " + type);
        }

        Transaction transaction = new Transaction(clientName, amount, type, paymentDetails);
        try {
            Bank bank = router.routeTransaction(transaction);
            TransactionStatus status = bank.processPayment(transaction);
            transaction.setStatus(status);
            return status;
        } catch (IllegalStateException e) {
            transaction.setStatus(TransactionStatus.FAILURE);
            return TransactionStatus.FAILURE;
        }
    }

    private PaymentMethod getPaymentMethod(PaymentMethodType type) {
        return supportedPaymentMethods.stream()
                .filter(pm -> pm.getType() == type)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Unsupported payment method: " + type));
    }
}
