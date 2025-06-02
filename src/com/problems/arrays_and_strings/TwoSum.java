package com.problems.arrays_and_strings;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        int[] nums = new int[] {2,7,11,15};
        int target = 9;
        int[] ans = twoSum(nums, target);
        System.out.println(ans.length);
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0;i<nums.length;i++) {
            int complementSum = target - nums[i];
            if (map.containsKey(complementSum)) {
                return new int[] {map.get(complementSum), i};
            }
            map.put(nums[i], i);
        }
        return new int[0];
    }
}
