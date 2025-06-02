package com.problems.arrays_and_strings;

public class MaximumSubarray {
    public static void main(String[] args) {
        int[] nums = new int[] {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums));
    }

    // Using Kadane's Algorithm
    public static int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int currentSum = 0;
        for(int num : nums) {
            currentSum += num;
            if (currentSum > maxSum) maxSum = currentSum;
            if (currentSum < 0) currentSum = 0;
        }
        return maxSum;
    }
}
