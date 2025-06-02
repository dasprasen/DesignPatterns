package com.problems.arrays_and_strings;

public class Power {
    public static void main(String[] args) {
        double x = 2.00000;
        int n = 10;
        System.out.println(myPow(x, n));
    }

    public static double myPow(double x, int n) {
        if (n == 0) return 1;
        long N = n;
        if (N < 0) {
            N = -N;
            x = 1 / x;
        }
        if (n % 2 == 0) {
            return myPow(x * x, (int) N/2);
        } else {
            return x * myPow(x, (int) N -1);
        }
    }
}
