package com.problems;

public class TwoSum_II {
    public static void main(String[] args) {
        int[] nums = new int[] {-1,0};
        int[] res = twoSum(nums, -1);
        for (int r : res) {
            System.out.println(r);
        }
    }

    public static int[] twoSum(int[] numbers, int target) {
        int i=0, j=numbers.length - 1;
        while(i <= j) {
            int sum = numbers[i] + numbers[j];
            if(sum == target) {
                return new int[] {i+1, j+1};
            } else if (sum > target) {
                j--;
            } else {
                i++;
            }
        }
        return new int[] {-1, -1};
    }
}
