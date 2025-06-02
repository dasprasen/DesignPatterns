package com.problems.arrays_and_strings;

public class ReverseWordInString {
    public static void main(String[] args) {
        System.out.println(reverseWords("  hello world  "));
    }

    public static String reverseWords(String s) {
        s = s.trim().replaceAll("\\s+", " ");
        String[] str = s.split(" ");
        StringBuilder sb = new StringBuilder();
        int i;
        for (i=str.length-1;i>=1;i--) {
            sb.append(str[i]).append(" ");
        }
        sb.append(str[i]);
        return sb.toString();
    }
}