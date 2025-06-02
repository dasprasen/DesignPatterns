package com.problems.arrays_and_strings;

public class NextPermutation {
    public static void main(String[] args) {
        int[] nums = new int[] {2, 3, 1};
        nextPermutation(nums);
    }

    public static void nextPermutation(int[] nums) {
        int n = nums.length;
        int i = n-2;
        while(i>=0 && nums[i] >= nums[i+1]) {
            i--;
        }

        if (i >= 0) {
            int j = n-1;
            while(nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i+1, n-1);
    }

    public static void reverse(int[] nums, int start, int end) {
        while(start<end) {
            swap(nums, start++, end--);
        }
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
