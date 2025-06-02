package com.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EncodeDecodeString {
    public static void main(String[] args) {
        String[] original1 = {"Hello", "World", "How", "Are", "You"};
        String encoded1 = encode(original1);
        String[] decoded1 = decode(encoded1);

        System.out.println("Original: " + Arrays.toString(original1));
        System.out.println("Encoded: " + encoded1);
        System.out.println("Decoded: " + Arrays.toString(decoded1));
        System.out.println("Match: " + Arrays.equals(original1, decoded1));

        // Test case 2: Empty strings and special characters
        String[] original2 = {"", "abc", "#test", "123", "!@#$%"};
        String encoded2 = encode(original2);
        String[] decoded2 = decode(encoded2);

        System.out.println("\nOriginal: " + Arrays.toString(original2));
        System.out.println("Encoded: " + encoded2);
        System.out.println("Decoded: " + Arrays.toString(decoded2));
        System.out.println("Match: " + Arrays.equals(original2, decoded2));
    }

    public static String encode(String strs[]) {
        // write your logic to encode the strings
        if (strs == null || strs.length == 0) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(str.length()).append("#").append(str);
        }
        return sb.toString();
    }

    public static String[] decode(String s) {
        // write your logic to decode the string
        if (s == null || s.isEmpty()) {
            return new String[0];
        }

        List<String> result = new ArrayList<>();
        int i = 0;
        while(i<s.length()) {
            int delimiterPos = s.indexOf("#", i);
            int length = Integer.parseInt(s.substring(i, delimiterPos));
            String str = s.substring(delimiterPos + 1, delimiterPos + 1 + length);
            result.add(str);
            i = delimiterPos + 1 + length;
        }
        return result.toArray(new String[0]);
    }
}
