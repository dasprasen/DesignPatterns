package com.streams;

import java.util.Arrays;

public class Parallel_Stream {
    public static void main(String[] args) {
        int[] arr = new int[1000000];
        Arrays.fill(arr, 2);

        long startTime = System.currentTimeMillis();

        long sum = Arrays.stream(arr)
                .mapToLong(n -> n * n)
                .sum();

        long endTime = System.currentTimeMillis();

        System.out.println("time taken by stream to do sum: " + (endTime - startTime));

        long startTimeP = System.currentTimeMillis();

        long sumP = Arrays.stream(arr)
                .parallel()
                .mapToLong(n -> n * n)
                .sum();

        long endTimeP = System.currentTimeMillis();

        System.out.println("time taken by parallelstream to do sum: " + (endTimeP - startTimeP));
    }
}
