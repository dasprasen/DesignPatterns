package com.design.splitwise_lld;

import java.util.ArrayList;
import java.util.List;

public class Group {
    private String groupId;
    private String name;
    private List<User> members;
    private List<Expense> expenses;

    public Group(String groupId, String name, List<User> members) {
        this.groupId = groupId;
        this.name = name;
        this.members = members;
        this.expenses = new ArrayList<>();
    }

    public void addMember(User user) {
        members.add(user);
    }

    public void addExpense(Expense expense) {
        expenses.add(expense);
    }

    public String getGroupId() {
        return groupId;
    }

    public String getName() {
        return name;
    }

    public List<User> getMembers() {
        return members;
    }

    public List<Expense> getExpenses() {
        return expenses;
    }
}
