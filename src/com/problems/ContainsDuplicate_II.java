package com.problems;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate_II {
    public static void main(String[] args) {
        int[] nums = new int[] {1,2,3,1,2,3};
        int k = 2;
        System.out.println(containsNearbyDuplicate(nums, k));
    }

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer,Integer> mpp = new HashMap<>();
        for(int i = 0; i<nums.length; i++){
            if(mpp.containsKey(nums[i])){
                if(i-mpp.get(nums[i])<=k) return true;
            }
            mpp.put(nums[i],i);
        }
        return false;
    }
}
