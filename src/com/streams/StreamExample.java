package com.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamExample {
    public static void main(String[] args) {
        int[] a = {1,2,3};
        IntStream intStream = Arrays.stream(a);
        List<Integer> list = Arrays.asList(1,2,3,4);
        Stream<Integer> intStream1 = list.stream();
        Stream<Integer> intStream2 = Stream.of(1,2,3,4);

        //Intermediate Operations -> filter, map, flatmap, distinct, sorted, limit, skip
        //Terminal Operations -> collect, reduce, count, forEach, anyMatch, allMatch, findFirst, findAny

        // Find the first even number which is greater than 3 in a list
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9);

        Optional<Integer> result = numbers.stream().filter(n -> n % 2 == 0 && n > 3).findFirst();
        System.out.println(result.get());

        //Second smallest Number in a list
        List<Integer> nums = Arrays.asList(5, 1, 4, 2, 3);
        Optional<Integer> res = nums.stream().sorted().skip(1).findFirst();
        System.out.println(res.get());

        //Count the frequency of each words in a string hello: 2, world: 2, to: 1
        String str = "hello world hello welcome to world";
        Map<String, Long> stringList = Arrays.stream(str.split(" ")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(stringList);



    }
}
