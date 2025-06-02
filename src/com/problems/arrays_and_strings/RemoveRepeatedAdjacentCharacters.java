package com.problems.arrays_and_strings;

public class RemoveRepeatedAdjacentCharacters {

    public static String removeAdjacentDuplicates(String str) {
        if (str == null || str.length() <= 1) {
            return str;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(str.charAt(0));
        for (int i=1;i<str.length();i++) {
            if (str.charAt(i) != str.charAt(i-1)) {
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(removeAdjacentDuplicates("aabbcc"));
        System.out.println(removeAdjacentDuplicates("aaabbbccc"));
        System.out.println(removeAdjacentDuplicates("abccba"));
    }
}
