package com.problems.arrays_and_strings;

import java.util.ArrayList;

public class ReversePairs {
    public static void main(String[] args) {
        int[] nums = new int[] {2,4,3,5,1};
        System.out.println(reversePairs(nums));
    }

    public static int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }

    private static int mergeSort(int[] nums, int start, int end) {
        if (start >= end)   return 0;
        int mid = start + (end - start) / 2;
        int count = mergeSort(nums, start, mid) + mergeSort(nums, mid+1, end);
        count += countPairs(nums, start, mid, end);
        merge(nums, start, mid, end);
        return count;
    }

    private static int countPairs(int[] nums, int start, int mid, int end) {
        int j = mid + 1;
        int count = 0;
        for (int i= start;i<=mid;i++) {
            while (j <= end &&  nums[i] > 2L * nums[j]) {
                j++;
            }
            count += (j - (mid + 1));
        }
        return count;
    }

    private static void merge(int[] nums, int start, int mid, int end) {
        int[] temp = new int[end - start + 1];
        int left = start;
        int right = mid+1;
        int index = 0;
        while(left <= mid && right <= end) {
            if(nums[left] <= nums[right]) {
                temp[index++] = nums[left++];
            } else {
                temp[index++] = nums[right++];
            }
        }
        while(left <= mid) {
            temp[index++] = nums[left++];
        }
        while(right <= end) {
            temp[index++] = nums[right++];
        }

        for(int i = 0; i < temp.length; i++) {
            nums[start + i] = temp[i];
        }
    }
}
