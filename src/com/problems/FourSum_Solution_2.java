package com.problems;

import java.util.*;

public class FourSum_Solution_2 {
    public static void main(String[] args) {
        int[] nums = new int[] {1,0,-1,0,-2,2};
        int target = 0;
        List<List<Integer>> res = fourSum(nums, target);
        System.out.println(res.stream().iterator().toString());
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Set<List<Integer>> list = new HashSet<>();
        int n = nums.length;
        if (n < 4) return new ArrayList<>(list);
        Arrays.sort(nums);
        for(int i=0;i<n-3;i++) {
            for(int j=i+1;j<n-2;j++) {
                int low = j+1, high = n-1;
                while (low < high) {
                    int sum = nums[i] + nums[low] + nums[high];
                    if (sum == target) {
                        list.add(Arrays.asList(nums[i], nums[low], nums[high]));
                    }
                    if (sum > target) {
                        high--;
                    } else {
                        low++;
                    }
                }
            }
        }
        return new ArrayList<>(list);
    }
}
