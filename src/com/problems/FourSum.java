package com.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
    public static void main(String[] args) {
        int[] arr = new int[] {10, 2, 3, 1, 0, 11, 6, 5};
        int k = 6;
        ArrayList<ArrayList<Integer>> res = fourSum(arr, k);
        List<List<Integer>> res1 = fourSum_1(arr, k);
        System.out.println(res1.size());
    }

    public static ArrayList<ArrayList<Integer>> fourSum(int[] arr, int k) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        Arrays.sort(arr);
        for (int i=0;i<arr.length-3;i++) {
            if(i>0 && arr[i] == arr[i-1])
                continue;
            for (int j=i+1;j<arr.length-2;j++) {
                if(j>i+1 && arr[j] == arr[j-1])
                    continue;
                int left = j+1;
                int right = arr.length - 1;
                while(left < right) {
                    int sum = arr[i] + arr[j] + arr[left] + arr[right];
                    if( sum == k) {
                        res.add(new ArrayList<>(Arrays.asList(arr[i], arr[j], arr[left], arr[right])));
                        while (left < right && arr[left] == arr[left + 1])
                            left++;
                        while (left < right && arr[right] == arr[right - 1])
                            right--;
                        left++;
                        right--;
                    } else if (sum < k) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return res;
    }

    public static List<List<Integer>> fourSum_1(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;
        if (n < 4)
            return result;
        Arrays.sort(nums);
        for (int i=0;i<n-3;i++) {
            if (i > 0 && nums[i] == nums[i+1])
                continue;
            long minSum = (long) nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3];
            if (minSum > target)
                break;
            long maxSum = (long) nums[i] + nums[n-3] + nums[n - 2] + nums[n - 1];
            if (maxSum < target)
                continue;
            for (int j = i + 1;j<n-2; j++) {
                if (j > i + 1 && nums[j] == nums[j-1])
                    continue;
                long minSumJ = (long) nums[i] + nums[j] + nums[j + 1] + nums[j + 2];
                if (minSumJ > target)
                    break;

                long maxSumJ = (long) nums[i] + nums[j] + nums[n - 2] + nums[n - 1];
                if (maxSumJ < target)
                    continue;
                int left = j + 1;
                int right = n - 1;
                while(left < right) {
                    long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum == target) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        while (left < right && nums[left] == nums[left + 1])
                            left++;
                        while (left < right && nums[right] == nums[right - 1])
                            right--;
                        left++;
                        right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return result;
    }
}
