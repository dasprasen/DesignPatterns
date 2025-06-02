package com.problems.arrays_and_strings;

import java.util.Arrays;

public class MergeSortedArray {
    public static void main(String[] args) {
        int[] nums1 = new int[] {1,2,3,0,0,0};
        int[] nums2 = new int[] {2,5,6};
        merge_1(nums1, 3, nums2, 3);
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] ans = new int[m + n];
        int i=0, j=0, k=0;
        while(i < nums1.length && j < nums2.length) {
            if (i < m && (nums1[i] < nums2[j])) {
                ans[k++] = nums1[i++];
            } else {
                ans[k++] = nums2[j++];
            }
        }

        while(i<nums1.length && i<m) {
            ans[k++] = nums1[i++];
        }

        while(j < nums2.length) {
            ans[k++] = nums2[j++];
        }

        for (int t = 0;t<m+n;t++) {
            nums1[t] = ans[t];
        }
    }

    // Optimal Approach
    public static void merge_1(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;
        while (i >=0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }
        while(j >= 0) {
            nums1[k--] = nums2[j--];
        }
    }
}
