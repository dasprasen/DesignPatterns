package com.design.splitwise_lld;

import java.util.Arrays;
import java.util.List;

public class SplitwiseApplication {
    private UserService userService;
    private GroupService groupService;
    private ExpenseService expenseService;

    public SplitwiseApplication() {
        userService = new UserService();
        groupService = new GroupService(userService);
        expenseService = new ExpenseService(userService, groupService);
    }

    public void demo() {

        User alice = userService.createUser("Alice", "alice@example.com", "1234567890");
        User bob = userService.createUser("Bob", "bob@example.com", "2345678901");
        User charlie = userService.createUser("Charlie", "charlie@example.com", "3456789012");

        System.out.println("Users created:");
        System.out.println("- " + alice.getName() + " (" + alice.getUserId() + ")");
        System.out.println("- " + bob.getName() + " (" + bob.getUserId() + ")");
        System.out.println("- " + charlie.getName() + " (" + charlie.getUserId() + ")");
        System.out.println();

        // Create group
        List<String> members = Arrays.asList(alice.getUserId(), bob.getUserId(), charlie.getUserId());
        Group group = groupService.createGroup("Trip to Mountains", members);

        System.out.println("Group created: " + group.getName() + " (" + group.getGroupId() + ")");
        System.out.println("Members: " + group.getMembers());
        System.out.println();

        // Add expenses
        System.out.println("Adding expenses...");
        expenseService.createExpense(300, "Hotel", alice.getUserId(),
                members, group.getGroupId());

        System.out.println("1. Alice paid ₹300 for Hotel (split equally among all)");

        expenseService.createExpense(150, "Food", bob.getUserId(),
                members, group.getGroupId());

        System.out.println("2. Bob paid ₹150 for Food (split equally among all)");
        System.out.println();

        // Show balances
        System.out.println("Current balances:");
        System.out.println("Alice:");
        System.out.println(BalanceFormatter.getFormattedBalances(alice));
        System.out.println("Bob:");
        System.out.println(BalanceFormatter.getFormattedBalances(bob));
        System.out.println("Charlie:");
        System.out.println(BalanceFormatter.getFormattedBalances(charlie));
        System.out.println();

        // Settle up
        System.out.println("Charlie settles ₹100 with Alice");
        expenseService.settleDebt(charlie.getUserId(), alice.getUserId(), 100);
        System.out.println();

        // Show updated balances
        System.out.println("Updated balances after settlement:");
        System.out.println("Alice:");
        System.out.println(BalanceFormatter.getFormattedBalances(alice));
        System.out.println("Bob:");
        System.out.println(BalanceFormatter.getFormattedBalances(bob));
        System.out.println("Charlie:");
        System.out.println(BalanceFormatter.getFormattedBalances(charlie));
    }

    public static void main(String[] args) {
        SplitwiseApplication app = new SplitwiseApplication();
        app.demo();
    }
}
