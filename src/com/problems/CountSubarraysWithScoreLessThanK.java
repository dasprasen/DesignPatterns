package com.problems;

public class CountSubarraysWithScoreLessThanK {
    public static void main(String[] args) {
        int[] nums = new int[] {2,1,4,3,5};
        long k = 10;
        System.out.println(countSubarrays(nums, k));
    }

    public static long countSubarrays(int[] nums, long k) {
        int left = 0, right = 0, count = 0;
        long currentSum = 0;
        for(right = 0; right < nums.length;right++) {
            currentSum += nums[right];
            while(left <= right && currentSum * (right - left + 1) >= k) {
                currentSum -= nums[left];
                left++;
            }
            count += (right - left + 1);
        }
        return count;
    }
}
