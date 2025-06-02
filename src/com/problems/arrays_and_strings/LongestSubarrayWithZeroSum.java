package com.problems.arrays_and_strings;

import java.util.HashMap;
import java.util.Map;

public class LongestSubarrayWithZeroSum {
    public static void main(String[] args) {
        int[] nums = new int[] {9, -3, 3, -1, 6, -5};
        System.out.println(maxLen(nums, nums.length));
    }

    private static int maxLen(int[] nums, int n) {
        Map<Integer, Integer> map = new HashMap<>();
        int maxi = 0, sum = 0;
        for(int i=0;i<n;i++) {
            sum += nums[i];
            if (sum == 0) {
                maxi = i +  1;
            } else {
                if (map.get(sum) != null) {
                    maxi = Math.max(maxi, i - map.get(sum));
                } else {
                    map.put(sum, i);
                }
            }
        }
        return maxi;
    }
}
