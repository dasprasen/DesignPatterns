package com.design.splitwise_lld;

import java.util.Date;
import java.util.List;

public class Expense {
    private String expenseId;
    private String description;
    private double amount;
    private User paidBy;
    private Date createdAt;
    private List<Split> splits;

    public Expense(String expenseId, double amount, String description, User paidBy, Date createdAt, List<Split> splits) {
        this.expenseId = expenseId;
        this.amount = amount;
        this.description = description;
        this.paidBy = paidBy;
        this.createdAt = createdAt;
        this.splits = splits;
    }

    public String getExpenseId() {
        return expenseId;
    }

    public String getDescription() {
        return description;
    }

    public double getAmount() {
        return amount;
    }

    public User getPaidBy() {
        return paidBy;
    }

    public List<Split> getSplits() {
        return splits;
    }

    public Date getCreatedAt() {
        return createdAt;
    }
}
