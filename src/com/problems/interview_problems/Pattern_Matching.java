package com.problems.interview_problems;

/*
Microsoft 1st round
'.' matches any single character
'*' matches zero or more of the preceding character
We need to match the entire string with the pattern
 */
public class Pattern_Matching {
    public static void main(String[] args) {
        String s = "azcc";
        String p = "a*b.cc*";
        System.out.println(isMatch(s, p));
        System.out.println(isMatch_DP(s, p));
    }

    // Time Complexity: O(2^(m+n)) - exponential due to overlapping sub-problems
    // Space Complexity: O(m+n) - recursion stack depth
    public static boolean isMatch(String s, String p) {
        if (p.isEmpty())
            return s.isEmpty();
        boolean firstCharMatch = (!s.isEmpty() && (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.'));
        if (p.length() >= 2 && p.charAt(1) == '*') {
            return (isMatch(s, p.substring(2)) || (firstCharMatch && isMatch(s.substring(1), p)));
        } else {
            return firstCharMatch && isMatch(s.substring(1), p.substring(1));
        }
    }

    // Optimized (DP Approach)
    public static boolean isMatch_DP(String s, String p) {
        int m = s.length();
        int n = p.length();

        // dp[i][j] represents if s[0...i-1] matches p[0...j-1]
        boolean[][] dp = new boolean[m + 1][n + 1];

        // Empty pattern matches empty string
        dp[0][0] = true;

        // Handle patterns like a*, a*b*, a*b*c* which can match empty string
        for (int j = 2; j <= n; j += 2) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 2];
            }
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char sc = s.charAt(i - 1);
                char pc = p.charAt(j - 1);

                if (pc == '*') {
                    // Current pattern character is '*'
                    // Check the character before '*'
                    char prevPC = p.charAt(j - 2);

                    // Two options:
                    // 1. Don't use the pattern (0 occurrences) - dp[i][j-2]
                    // 2. Use the pattern if characters match - dp[i-1][j]
                    dp[i][j] = dp[i][j - 2] ||
                            (charMatch(sc, prevPC) && dp[i - 1][j]);
                } else {
                    // Current pattern character is not '*'
                    // Characters must match and previous state should be true
                    dp[i][j] = charMatch(sc, pc) && dp[i - 1][j - 1];
                }
            }
        }
        return dp[m][n];
    }

    private static boolean charMatch(char sc, char pc) {
        return pc == '.' || sc == pc;
    }
}
