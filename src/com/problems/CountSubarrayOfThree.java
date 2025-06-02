package com.problems;

public class CountSubarrayOfThree {
    public static void main(String[] args) {
        int[] nums = new int[] {1,2,1,4,1};
        System.out.println(countSubarrays(nums));
    }

    public static int countSubarrays(int[] nums) {
        int count = 0;
        for(int i=0;i<=nums.length-3;i++) {
            if(2 * (nums[i] + nums[i+2]) == nums[i+1]) {
                count++;
            }
        }
        return count;
    }
}
