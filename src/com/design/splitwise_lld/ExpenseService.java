package com.design.splitwise_lld;

import java.util.*;

public class ExpenseService {
    private Map<String, Expense> expenses;
    private UserService userService;
    private GroupService groupService;

    public ExpenseService(UserService userService, GroupService groupService) {
        this.userService = userService;
        this.groupService = groupService;
        this.expenses = new HashMap<>();
    }

    public Expense createExpense(double amount, String description, String paidByUserId, List<String> participantUserIds, String groupId) {
        User paidBy = userService.getUser(paidByUserId);
        List<User> participants = new ArrayList<>();
        for(String userId : participantUserIds) {
            participants.add(userService.getUser(userId));
        }

        double splitAmount = amount / participants.size();
        List<Split> splits = new ArrayList<>();
        for (User user : participants) {
            EqualSplit split = new EqualSplit(user, splitAmount);
            splits.add(split);
            if(!participants.equals(paidBy)) {
                user.updateBalance(paidBy, splitAmount);
                paidBy.updateBalance(user, -splitAmount);
            }
         }

        String expenseId = UUID.randomUUID().toString();
        Expense expense = new Expense(expenseId, amount, description, paidBy, new Date(), splits);
        if (groupId != null) {
            Group group = groupService.getGroup(groupId);
            group.addExpense(expense);
        }

        expenses.put(expense.getExpenseId(), expense);
        return expense;
    }

    public Map<User, Double> getBalances(String userId) {
        User user = userService.getUser(userId);
        return user.getBalances();
    }

    public void settleDebt(String payerId, String payeeId, double amount) {
        User payer = userService.getUser(payerId);
        User payee = userService.getUser(payeeId);

        payer.updateBalance(payee, -amount);
        payee.updateBalance(payer, amount);
    }

    public Map<String, Expense> getExpenses() {
        return expenses;
    }
}
