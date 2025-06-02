package com.problems.arrays_and_strings;

import java.util.ArrayList;

public class CountInversions {
    public static void main(String[] args) {
        int[] arr = new int[] {2,4,1,3,5};
        System.out.println(inversionCount(arr));
    }

    public static int inversionCount(int arr[]) {
        return mergeSort(arr, 0, arr.length-1);
    }

    private static int mergeSort(int[] arr, int low, int high) {
        if (low >= high)    return 0;
        int mid = (low + high) / 2;
        int inversions = 0;
        inversions += mergeSort(arr, low, mid);
        inversions += mergeSort(arr, mid + 1, high);
        inversions += merge(arr, low, mid, high);
        return inversions;
    }

    private static int merge(int[] arr, int low, int mid, int high) {
        ArrayList<Integer> temp = new ArrayList<>();
        int left = low;
        int right = mid + 1;
        int inversions = 0;
        while(left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                temp.add(arr[left]);
                left++;
            } else {
                temp.add(arr[right]);
                inversions += (mid - left + 1);
                right++;
            }
        }

        while (left <= mid) {
            temp.add(arr[left]);
            left++;
        }

        while (right <= high) {
            temp.add(arr[right]);
            right++;
        }
        for (int i=low;i<=high;i++) {
            arr[i] = temp.get(i - low);
        }
        return inversions;
    }


}
