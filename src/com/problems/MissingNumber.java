package com.problems;

public class MissingNumber {
    public static void main(String[] args) {
        int[] nums = new int[] {11, 12, 14, 15};
        System.out.println(missingNum_1(nums));
        System.out.println(missingNum_2(nums));
        System.out.println(missingNum_3(nums));
        System.out.println(missingNum_4(nums));
    }

    public static int missingNum_1(int[] nums) {
        int left = 0, right = nums.length - 1;
        if (nums[right] - nums[0] == right) {
            return -1;
        }
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] - nums[0] == mid) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return nums[left-1] + 1;
    }

    public static int missingNum_2(int[] nums) {
        int expeectedSum = 0, actualSum = 0;
        int n = nums.length;
        expeectedSum = (nums.length + 1) * (nums[0] + nums[n-1]) / 2;
        for (int num : nums) {
            actualSum += num;
        }
        return expeectedSum - actualSum;
    }

    public static int missingNum_3(int[] nums) {
        for(int i = 1; i<nums.length;i++) {
            if (nums[i] - nums[i-1] > 1) {
                return nums[i-1] + 1;
            }
        }
        return -1;
    }

    public static int missingNum_4(int[] nums) {
        int actualXOR = 0, expectedXOR = 0;
        for(int i=nums[0];i<=nums[nums.length-1];i++) {
            expectedXOR ^= i;
        }

        for(int num : nums) {
            actualXOR ^= num;
        }

        return expectedXOR ^ actualXOR;
    }
}
