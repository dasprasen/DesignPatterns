package com.design.payment_gateway_lld;

import java.util.HashMap;
import java.util.Map;

public class PaymentMethod {
    private PaymentMethodType type;
    private Map<String, String> requiredParams;

    public PaymentMethod(PaymentMethodType type) {
        this.type = type;
        this.requiredParams = new HashMap<>();
        initRequiredParams();
    }

    private void initRequiredParams() {
        switch (type) {
            case UPI:
                requiredParams.put("vpa", "UPI Virtual Payment Address");
                break;
            case CREDIT_CARD:
            case DEBIT_CARD:
                requiredParams.put("cardNumber", "16-digit Card Number");
                requiredParams.put("expiryDate", "MM/YY format");
                requiredParams.put("cvv", "3-digit CVV");
                requiredParams.put("cardHolderName", "Name on card");
                break;
            case NETBANKING:
                requiredParams.put("username", "Bank Username");
                requiredParams.put("password", "Bank Password");
                requiredParams.put("bankCode", "Bank Code");
                break;
        }
    }

    public PaymentMethodType getType() {
        return type;
    }

    public Map<String, String> getRequiredParams() {
        return requiredParams;
    }

}
