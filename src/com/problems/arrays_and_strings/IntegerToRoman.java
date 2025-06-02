package com.problems.arrays_and_strings;

// Implement a highly optimized solution for converting integers to Roman numerals without hardcoding mappings, leveraging arrays and modular logic.
public class IntegerToRoman {
    public String intToRoman(int num) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romans = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder result = new StringBuilder();
        int i = 0;

        while (num > 0 && i < values.length) {
            while (num >= values[i]) {
                result.append(romans[i]);
                num -= values[i];
            }
            i++;
        }
        return result.toString();
    }
    public static void main(String[] args) {
        IntegerToRoman converter = new IntegerToRoman();
        int[] testNumbers = {3, 10, 8, 7, 58, 1994, 3749, 2023};

        System.out.println("Integer → Roman Conversion Tests:");
        System.out.println("=".repeat(35));

        for (int num : testNumbers) {
            String roman = converter.intToRoman(num);
            System.out.printf("%4d → %-10s\n", num, roman);
        }
    }
}
