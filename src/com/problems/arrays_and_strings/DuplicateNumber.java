package com.problems.arrays_and_strings;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class DuplicateNumber {
    public static void main(String[] args) {
        int[] nums = new int[] {1,3,4,5,6,2,2}; // 1 2 2 3 4 5 6
        System.out.println(findDuplicate_4(nums));
    }

    public static int findDuplicate_1(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num : nums) {
            if (set.contains(num)) {
                return num;
            }
            set.add(num);
        }
        return -1;
    }

    public static int findDuplicate_2(int[] nums) {
        Arrays.sort(nums);
        for (int i=0;i<nums.length;i++) {
            if(nums[i] == nums[i+1]) {
                return nums[i];
            }
        }
        return -1;
    }

    public static int findDuplicate_3(int[] nums) {
        int low = 1;
        int high = nums.length-1;
        while(low < high) {
            int mid = low + (high - low) / 2;
            int count = 0;
            for(int num : nums) {
                if(num <= mid) count++;
            }
            if (count > mid) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    // Floyd's Cycle Detection algorithm
    public static int findDuplicate_4(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];

        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        slow = nums[0];
        while(slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}
