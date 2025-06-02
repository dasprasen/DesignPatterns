package com.streams;

import java.util.Arrays;
import java.util.List;

public class Map_Vs_FlatMap {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("hello", "world");

        // using map to convert each word to uppercase
        List<String> uppercaseWords = words.stream()
                .map(String::toUpperCase)
                .toList();
        System.out.println("using maps: " + uppercaseWords);

        List<List<Integer>> nestedList = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(4, 5, 6),
                Arrays.asList(8, 9, 10)
        );

        // using flatmap to flatten the nested list
        List<Integer> flattenedList = nestedList.stream().flatMap(List::stream).toList();
        System.out.println("flattened list: " + flattenedList);
    }
}
