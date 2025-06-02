package com.design.splitwise_lld;

import java.util.Map;

public class BalanceFormatter {
    public static String getFormattedBalances(User user) {
        StringBuilder result = new StringBuilder();
        for (Map.Entry<User, Double> balance : user.getBalances().entrySet()) {
            double amount = balance.getValue();
            User otherUser = balance.getKey();

            if (amount > 0) {
                result.append(user.getName()).append(" owes ").append(otherUser.getName())
                        .append(" ₹").append(String.format("%.2f", amount)).append("\n");
            } else if (amount < 0) {
                result.append(otherUser.getName()).append(" owes ").append(user.getName())
                        .append(" ₹").append(String.format("%.2f", Math.abs(amount))).append("\n");
            }
        }

        return result.length() > 0 ? result.toString() : "No balances";
    }
}
