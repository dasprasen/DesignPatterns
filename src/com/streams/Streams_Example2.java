package com.streams;

import java.util.Arrays;
import java.util.List;

public class Streams_Example2 {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 3, 4, 5, 5, 6, 7, 8, 8, 9, 10);

        List<Integer> squaredNumbers = numbers.stream()
                .filter(n -> n % 2 == 0) // filter even numbers
                .map(n -> n * n) // square the numbers
                .distinct() // remove duplicates
                .peek(System.out::println) // peek into the stream
                .toList();
        System.out.println("squared numbers: " + squaredNumbers);


        long count = numbers.stream()
                .filter(n -> n > 5)
                .count();

        System.out.println("count of numbers greater than 5: " + count);

        // sum of numbers
        int sum = numbers.stream()
                .mapToInt(n -> n)
                .sum();
        System.out.println("sum of numbers: " + sum);
    }
}
