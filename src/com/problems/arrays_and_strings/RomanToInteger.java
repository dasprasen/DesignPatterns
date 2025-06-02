package com.problems.arrays_and_strings;

import java.util.*;

public class RomanToInteger {

    public static void main(String[] args) {
        String s = "MCMXCIV";
        System.out.println(romanToInt(s));
    }

    public static int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int integerValue = 0;
        for (int i=0;i<s.length();i++) {
            int currentValue = map.get(s.charAt(i));
            if (((i+1) < s.length()) && currentValue < map.get(s.charAt(i+1))) {
                integerValue -= currentValue;
            } else {
                integerValue += currentValue;
            }
        }
        return integerValue;
    }
}
