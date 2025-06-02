package com.streams;

import java.util.Arrays;
import java.util.List;

class Transaction {
    private String category;
    private int amount;

    public Transaction(String category, int amount) {
        this.category = category;
        this.amount = amount;
    }

    public String getCategory() {
        return category;
    }

    public int getAmount() {
        return amount;
    }
}

public class Streams_Example1 {
    public static void main(String[] args) {
        List<Transaction> transactions = Arrays.asList(
                new Transaction("Grocery", 2500),
                new Transaction("Entertainment", 500),
                new Transaction("Grocery", 1500),
                new Transaction("Utilities", 1200),
                new Transaction("Utilities", 500),
                new Transaction("Entertainment", 1500)
        );

        // 1 Calculate the total amount spent on groceries
        int amount = transactions.stream()
                .filter(c -> c.getCategory().equals("Grocery"))
                .mapToInt(Transaction::getAmount).sum();
        System.out.println(amount);

        // 2 find the average expense across all categories
        double averageExpense = transactions.stream()
                .mapToDouble(Transaction::getAmount)
                .average().orElse(0.0);
        System.out.println("average expense: " + averageExpense);
    }
}
