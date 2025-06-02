package com.design.payment_gateway_lld;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        PaymentGateway pg = new PaymentGateway();

        // Add clients
        pg.addClient("Flipkart");
        pg.addClient("Amazon");

        // Add banks
        pg.addBank("HDFC");
        pg.addBank("ICICI");
        pg.addBank("SBI");

        // Configure payment method support for banks
        pg.addSupportForPaymentMethod(PaymentMethodType.CREDIT_CARD, null, "HDFC");
        pg.addSupportForPaymentMethod(PaymentMethodType.DEBIT_CARD, null, "HDFC");
        pg.addSupportForPaymentMethod(PaymentMethodType.UPI, null, "HDFC");
        pg.addSupportForPaymentMethod(PaymentMethodType.NETBANKING, null, "ICICI");
        pg.addSupportForPaymentMethod(PaymentMethodType.UPI, null, "ICICI");
        pg.addSupportForPaymentMethod(PaymentMethodType.UPI, null, "SBI");
        pg.addSupportForPaymentMethod(PaymentMethodType.NETBANKING, null, "SBI");

        // Configure payment method support for clients
        pg.addSupportForPaymentMethod(PaymentMethodType.CREDIT_CARD, "Flipkart", null);
        pg.addSupportForPaymentMethod(PaymentMethodType.DEBIT_CARD, "Flipkart", null);
        pg.addSupportForPaymentMethod(PaymentMethodType.UPI, "Flipkart", null);
        pg.addSupportForPaymentMethod(PaymentMethodType.NETBANKING, "Flipkart", null);

        pg.addSupportForPaymentMethod(PaymentMethodType.UPI, "Amazon", null);
        pg.addSupportForPaymentMethod(PaymentMethodType.CREDIT_CARD, "Amazon", null);

        // Configure routing distribution
        Map<String, Double> creditCardDistribution = new HashMap<>();
        creditCardDistribution.put("HDFC", 100.0);
        pg.setDistribution(PaymentMethodType.CREDIT_CARD, creditCardDistribution);

        Map<String, Double> netbankingDistribution = new HashMap<>();
        netbankingDistribution.put("ICICI", 70.0);
        netbankingDistribution.put("SBI", 30.0);
        pg.setDistribution(PaymentMethodType.NETBANKING, netbankingDistribution);

        Map<String, Double> upiDistribution = new HashMap<>();
        upiDistribution.put("HDFC", 40.0);
        upiDistribution.put("ICICI", 30.0);
        upiDistribution.put("SBI", 30.0);
        pg.setDistribution(PaymentMethodType.UPI, upiDistribution);

        Map<String, Double> debitCardDistribution = new HashMap<>();
        debitCardDistribution.put("HDFC", 100.0);
        pg.setDistribution(PaymentMethodType.DEBIT_CARD, debitCardDistribution);

        // Display current routing distribution
        System.out.println("Current Distribution:");
        pg.showDistribution().forEach((type, dist) -> {
            System.out.println(type + ": " + dist);
        });

        // Test UPI payment
        Map<String, String> upiDetails = new HashMap<>();
        upiDetails.put("vpa", "user@upi");
        TransactionStatus upiStatus = pg.makePayment("Flipkart", 1000.0, PaymentMethodType.UPI, upiDetails);
        System.out.println("UPI Payment Status: " + upiStatus);

        // Test Credit Card payment
        Map<String, String> cardDetails = new HashMap<>();
        cardDetails.put("cardNumber", "1234567890123456");
        cardDetails.put("expiryDate", "12/25");
        cardDetails.put("cvv", "123");
        cardDetails.put("cardHolderName", "John Doe");
        TransactionStatus cardStatus = pg.makePayment("Flipkart", 5000.0, PaymentMethodType.CREDIT_CARD, cardDetails);
        System.out.println("Credit Card Payment Status: " + cardStatus);

        // Test Netbanking payment
        Map<String, String> netbankingDetails = new HashMap<>();
        netbankingDetails.put("username", "user123");
        netbankingDetails.put("password", "pass123");
        netbankingDetails.put("bankCode", "ICICI");
        TransactionStatus netbankingStatus = pg.makePayment("Flipkart", 2000.0, PaymentMethodType.NETBANKING, netbankingDetails);
        System.out.println("Netbanking Payment Status: " + netbankingStatus);
    }
}
