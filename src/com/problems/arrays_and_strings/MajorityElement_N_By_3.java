package com.problems.arrays_and_strings;

import java.util.ArrayList;
import java.util.List;

public class MajorityElement_N_By_3 {
    public static void main(String[] args) {
        int[] nums = new int[] {3,2,3};
        List<Integer> res = majorityElement(nums);
        System.out.println(res.size());
    }

    public static List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int candidate1 = 0, candidate2 = 0;
        int count1 = 0, count2 = 0;
        for(int num : nums) {
            if(candidate1 == num) {
                count1++;
            } else if(candidate2 == num) {
                count2++;
            } else if(count1 == 0) {
                candidate1 = num;
                count1++;
            } else if(count2 == 0) {
                candidate2 = num;
                count2++;
            } else {
                count1--;
                count2--;
            }
        }

        count1=0;
        count2=0;
        for(int num : nums) {
            if(num == candidate1) {
                count1++;
            } else if(num == candidate2) {
                count2++;
            }
        }

        int n = nums.length;
        if(count1 > n/3) {
            res.add(candidate1);
        }

        if(count2 > n/3) {
            res.add(candidate2);
        }

        return res;
    }
}
