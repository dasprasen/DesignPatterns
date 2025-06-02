package com.problems.arrays_and_strings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MaxSubArrayWithUniqueElements {
    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(1, 2, 3, 4, 7, 7, 5);
        System.out.println(maxSubArrayWithUniqueElement(arr, 3));
    }

    public static long maxSubArrayWithUniqueElement(List<Integer> arr, int k) {
        int n = arr.size();
        if (n < k) return -1;
        long presentSum = 0;
        long maxSum = -1;
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int i=0;i<k;i++) {
            int number = arr.get(i);
            freqMap.put(number, freqMap.getOrDefault(number, 0) + 1);
            presentSum += number;
        }

        if (freqMap.size() == k) {
            maxSum = presentSum;
        }

        for (int i=k;i<n;i++) {
            int leftEle = arr.get(i - k);
            presentSum -= leftEle;
            freqMap.put(leftEle, freqMap.get(leftEle) - 1);
            if (freqMap.get(leftEle) == 0) {
                freqMap.remove(leftEle);
            }

            int rightEle = arr.get(i);
            presentSum += rightEle;
            freqMap.put(rightEle, freqMap.getOrDefault(rightEle, 0) + 1);
            if (freqMap.size() == k && presentSum > maxSum) {
                maxSum = presentSum;
            }
        }
        return maxSum;
    }
}
