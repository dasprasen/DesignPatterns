package com.problems.arrays_and_strings;

import java.util.Arrays;

public class UniquePaths {
    public static void main(String[] args) {
        System.out.println(uniquePaths_2(3, 7));
    }


    // Recursive and Memoization
    public static int uniquePaths(int m, int n) {
        Integer[][] memo = new Integer[m][n];
        return countPaths(0, 0, m, n, memo);
    }

    // Recursive and Memoization
    private static int countPaths(int i, int j, int m, int n, Integer[][] memo) {
        if (i == m-1 && j == n - 1) {
            return 1;
        }

        if (i >= m || j >= n) {
            return 0;
        }

        if (memo[i][j] != null) {
            return memo[i][j];
        }

        int rightPaths = countPaths(i, j + 1, m, n, memo);
        int downPaths = countPaths(i+1, j, m, n, memo);
        memo[i][j] = rightPaths + downPaths;
        return memo[i][j];
    }

    // Dynamic Programming (Bottom-Up) Time: O(m * n) Space: O(m * n)
    public static int uniquePaths_1(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }
        for(int i=1;i<m;i++) {
            for (int j=1;j<n;j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }

    // Space optimization
    public static int uniquePaths_2(int m, int n) {
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i=1;i<m;i++) {
            for (int j=1;j<n;j++) {
                dp[j] += dp[j-1];
            }
        }
        return dp[n-1];
    }
}
