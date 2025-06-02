package com.problems.arrays_and_strings;

public class SortColors {
    public static void main(String[] args) {
        int[] nums = new int[] {2,0,2,1,1,0};
        sortColors(nums);
    }

    public static void sortColors(int[] nums) {
        int[] freq = new int[3];
        for(int num : nums) {
            freq[num]++;
        }

        int j = 0;
        for(int i=0;i<freq[0];i++) {
            nums[j++] = 0;
        }

        for (int i=0;i<freq[1];i++ ) {
            nums[j++] = 1;
        }

        for (int i=0;i<freq[2];i++ ) {
            nums[j++] = 2;
        }
    }

    // Dutch National Flag Algorithm
    public static void sortColors_1(int[] nums) {
        int low = 0, mid = 0, high = nums.length - 1;
        while (mid <= high) {
            if (nums[mid] == 0) {
                swap(nums, low, mid);
                mid++;
                low++;
            } else if (nums[mid] == 1) {
                mid++;
            } else {
                swap(nums, mid, high);
                high--;
            }
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
