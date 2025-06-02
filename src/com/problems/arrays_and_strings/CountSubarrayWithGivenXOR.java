package com.problems.arrays_and_strings;

import java.util.HashMap;
import java.util.Map;

public class CountSubarrayWithGivenXOR {
    public static void main(String[] args) {
        int[] arr = new int[] {4, 2, 2, 6, 4};
        System.out.println(subarrayXor_1(arr, 6));
        System.out.println(subarrayXor_2(arr, 6));
    }

    // Time: O(n square) Space: O(1)
    public static long subarrayXor_1(int[] arr, int k) {
        int count = 0;
        for (int i = 0;i<arr.length;i++) {
            int xor = 0;
            for (int j=i;j<arr.length;j++) {
                xor  = xor ^ arr[j];
                if (xor == k) {
                    count++;
                }
            }
        }
        return count;
    }

    public static long subarrayXor_2(int[] arr, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        int count = 0, xor = 0;
        freqMap.put(0, 1);
        for(int i=0;i<arr.length;i++) {
            xor = xor ^ arr[i];
            int ele = xor ^ k;
            if (freqMap.containsKey(ele)) {
                count += freqMap.get(ele);
            }
            freqMap.put(xor, freqMap.getOrDefault(xor, 0) + 1);
        }
        return count;
    }
}
