package com.problems;

public class MergeStrings {
    public static void main(String[] args) {
        String res = mergeAlternately("abc", "pqr");
        System.out.println(res);
    }

    public static String mergeAlternately(String word1, String word2) {
        int i=0, j=0;
        StringBuilder res = new StringBuilder();
        while(i < word1.length() && j < word2.length()) {
            res.append(word1.charAt(i++));
            res.append(word2.charAt(j++));
        }
        if (i == word1.length()) {
            res.append(word2.substring(i));
        } else {
            res.append(word1.substring(j));
        }
        return res.toString();
    }
}
