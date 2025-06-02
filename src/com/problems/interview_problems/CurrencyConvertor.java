package com.problems.interview_problems;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// Given a file of currency conversion rates, write a function that converts one currency to another.
// Time: O(V!) Space: O(V)
public class CurrencyConvertor {
    private Map<String, Map<String, Double>> graph;

    public CurrencyConvertor(String[][] rates) {
        graph = new HashMap<>();
        buildGraph(rates);
    }

    private void buildGraph(String[][] rates) {
        for (String[] rate : rates) {
            String from = rate[0], to = rate[1];
            double conversionRate = Double.parseDouble(rate[2]);

            graph.putIfAbsent(from, new HashMap<>());
            graph.putIfAbsent(to, new HashMap<>());

            graph.get(from).put(to, conversionRate);
            graph.get(to).put(from, 1.0 / conversionRate);
        }
    }

    public double getConversionRate(String from, String to) {
        // Same currency case
        if (from.equals(to)) {
            return 1.0;
        }

        // Check if currencies exist
        if (!graph.containsKey(from) || !graph.containsKey(to)) {
            return -1.0; // Invalid currencies
        }

        // Start DFS with empty visited set
        Set<String> visited = new HashSet<>();
        return dfsHelper(from, to, visited);
    }

    private double dfsHelper(String current, String target, Set<String> visited) {
        if (current.equals(target)) {
            return 1.0;
        }
        visited.add(current);
        if (graph.containsKey(current)) {
            for (Map.Entry<String, Double> neighbor : graph.get(current).entrySet()) {
                String nextCurrency = neighbor.getKey();
                double rate = neighbor.getValue();

                if (!visited.contains(nextCurrency)) {
                    double result = dfsHelper(nextCurrency, target, visited);
                    if (result != -1) {
                        return rate * result;
                    }
                }
            }
        }
        visited.remove(current); // Backtrack
        return -1;
    }

    public static void main(String[] args) {
        String[][] rates = {
                {"USD", "EUR", "0.85"},
                {"EUR", "GBP", "1.1"},
                {"GBP", "INR", "100"},
                {"USD", "CAD", "1.25"},
                {"CAD", "AUD", "1.1"}
        };

        CurrencyConvertor converter = new CurrencyConvertor(rates);

        System.out.println("=== Currency Conversion Rates ===");

        // Test conversions (always for 1 unit)
        System.out.printf("1 USD = %.4f EUR%n",
                converter.getConversionRate("USD", "EUR"));

        System.out.printf("1 USD = %.4f GBP%n",
                converter.getConversionRate("USD", "GBP"));

        System.out.printf("1 USD = %.4f INR%n",
                converter.getConversionRate("USD", "INR"));

        System.out.printf("1 EUR = %.4f INR%n",
                converter.getConversionRate("EUR", "INR"));

        System.out.printf("1 CAD = %.4f EUR%n",
                converter.getConversionRate("CAD", "EUR"));

        System.out.printf("1 INR = %.4f USD%n",
                converter.getConversionRate("INR", "USD"));
    }
}
