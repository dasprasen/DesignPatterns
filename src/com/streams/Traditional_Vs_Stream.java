package com.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Traditional_Vs_Stream {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5, 6);

        //Traditional way
        int sumOfSquares = 0;
        for(int num : nums) {
            if (num % 2 == 0) {
                int square = num * num;
                sumOfSquares += square;
            }
        }
        System.out.println("Sum of squares (traditional): " + sumOfSquares);

        // Stream way
        int sumOfSquaresStreamWay = nums.stream()
                .filter(num -> num % 2 == 0) // filter even numbers
                .mapToInt(num -> num * num)// square the number
                .sum(); // sum the squared numbers
        System.out.println("Sum of squares (traditional): " + sumOfSquaresStreamWay);

    }
}
