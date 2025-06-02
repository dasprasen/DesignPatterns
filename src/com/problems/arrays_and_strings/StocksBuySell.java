package com.problems.arrays_and_strings;

public class StocksBuySell {
    public static void main(String[] args) {
        int[] prices = new int[] {7,1,5,3,6,4};
        System.out.println(maxProfit(prices));
    }

    // Brute Force
    public static int maxProfit(int[] prices) {
        int maxPro = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[j] > prices[i]) {
                    maxPro = Math.max(prices[j] - prices[i], maxPro);
                }
            }
        }
        return maxPro;
    }

    // optimal approach
    public static int maxProfit_1(int[] prices) {
        int maxPro = 0, mini = Integer.MAX_VALUE;
        for (int price : prices) {
            if (price < mini) {
                mini = price;
            } else {
                maxPro = Math.max(maxPro, price - mini);
            }
        }
        return maxPro;
    }
}
