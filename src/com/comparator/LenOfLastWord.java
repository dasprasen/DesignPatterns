package com.comparator;

public class LenOfLastWord {
    public static void main(String[] args) {
        int ans = lengthOfLastWord("   fly me   to   the moon  ");
        System.out.println(ans);
    }

    public static int lengthOfLastWord(String s) {
        s = s.trim();
        int len=0;
        int i = s.length()-1;
        while (s.charAt(i) != ' ') {
            len++;
            i--;
        }
        return len;
    }
}
