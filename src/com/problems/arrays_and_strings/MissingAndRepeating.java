package com.problems.arrays_and_strings;

import java.util.ArrayList;
import java.util.Arrays;

public class MissingAndRepeating {
    public static void main(String[] args) {
        int[] nums = new int[] {1, 3, 3};
//        ArrayList<Integer> res = findTwoElement(nums);
//        for (Integer i : res) {
//            System.out.println(i);
//        }

        int[] result  = findTwoElement_3(nums);
        System.out.println(result.length);
    }

    static ArrayList<Integer> findTwoElement(int arr[]) {
        ArrayList<Integer> res = new ArrayList<>();
        int[] freq = new int[arr.length + 1];
        int repNum = -1, missNum = -1;
        for (int i : arr) {
            freq[i]++;
        }
        for (int i = 1;i<freq.length;i++) {
            if (freq[i] > 1) {
                repNum = i;
            } else if (freq[i] == 0) {
                missNum = i;
            }

            if (repNum != -1 && missNum != -1)
                break;
        }
        res.add(repNum);
        res.add(missNum);
        return res;
    }

    static ArrayList<Integer> findTwoElement_1(int arr[]) {
        ArrayList<Integer> res = new ArrayList<>();
        int n = arr.length;

        long actualSum = 0;
        long actualSumSquares = 0;
        for (int num : arr) {
            actualSum += num;
            actualSumSquares += (long)num * num;
        }
        long expectedSum = (long)n * (n + 1) / 2;
        long expectedSumSquares = (long)n * (n + 1) * (2 * n + 1) / 6;

        long sumDiff = expectedSum - actualSum;
        long sumSquaresDiff = expectedSumSquares - actualSumSquares;


        long sumOfMissingAndRepeating = sumSquaresDiff / sumDiff;

        int missing = (int)((sumDiff + sumOfMissingAndRepeating) / 2);
        int repeating = (int)(sumOfMissingAndRepeating - missing);
        res.add(repeating);
        res.add(missing);
        return res;
    }

    static int[] findTwoElement_3(int arr[]) {
        int n = arr.length;
        int xor = 0;
        for (int i = 0; i < n; i++) {
            xor ^= arr[i];
            xor ^= (i + 1);
        }
        int rightmostSetBit = xor & -xor;
        int x = 0, y = 0;
        for (int i = 0; i < n; i++) {
            if ((arr[i] & rightmostSetBit) != 0)
                x ^= arr[i];
            else
                y ^= arr[i];

            if (((i + 1) & rightmostSetBit) != 0)
                x ^= (i + 1);
            else
                y ^= (i + 1);
        }
        for (int num : arr) {
            if (num == x) {
                return new int[]{x, y};
            }
        }
        return new int[]{y, x};
    }

}
