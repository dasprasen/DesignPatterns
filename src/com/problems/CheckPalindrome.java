package com.problems;

public class CheckPalindrome {
    public static void main(String[] args) {
        String s = "xeroex";
        System.out.println(checkPalindrome(s, 0, s.length()-1));
    }

    public static boolean checkPalindrome(String s, int left, int right) {
        if (left >= right) {
            return true;
        }
        if (s.charAt(left) != s.charAt(right)) {
            return false;
        }
        return checkPalindrome(s, left+1, right-1);
    }
}
