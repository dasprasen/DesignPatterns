package com.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Arrays_To_Streams {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        IntStream stream = Arrays.stream(arr);
        stream.forEach(System.out::println);

        Double[] doubles = {23.34, 34.45};
        Stream<Double> doubleStream = Stream.of(doubles);
        doubleStream.forEach(System.out::println);

        // from Collections
        List<String> list = Arrays.asList("abc", "def");
        Stream<String> stringStream = list.stream();
        stringStream.forEach(System.out::println);

    }
}
