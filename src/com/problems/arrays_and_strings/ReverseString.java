package com.problems.arrays_and_strings;

public class ReverseString {

    public static int reverseInteger(int num) {
        int reversed = 0;
        boolean isNegative = num < 0;

        num = Math.abs(num);
        while (num > 0) {
            reversed = reversed * 10 + num % 10;
            num = num / 10;
        }
        return isNegative ? -reversed : reversed;
    }

    public static void main(String[] args) {
        System.out.println(reverseInteger(12345));  // Output: 54321
        System.out.println(reverseInteger(-123));   // Output: -321
        System.out.println(reverseInteger(1000));
    }
}
