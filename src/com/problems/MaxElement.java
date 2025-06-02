package com.problems;


public class MaxElement {
    public static void main(String[] args) {
        int[] arr = new int[] {8, 8, 2, 7, 8, 5, 1, 8, 2};
        System.out.println(maxEle(arr, 0));
    }

    public static int maxEle(int[] arr, int i) {
        if(i == arr.length-1)   return arr[i];
        int maxInRest = maxEle(arr, i+1);
        return Math.max(arr[i], maxInRest);
    }
}
