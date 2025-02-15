package com.problems;

import java.util.ArrayList;
import java.util.Arrays;

public class FourSum {
    public static void main(String[] args) {
        int[] arr = new int[] {0, 0, 2, 1, 1};
        int k = 3;
        ArrayList<ArrayList<Integer>> res = fourSum(arr, k);
        System.out.println(res);
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
}
