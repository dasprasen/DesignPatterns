package com.problems;

import java.util.HashMap;
import java.util.Map;

public class TotalFruits {
    public static void main(String[] args) {
        int[] fruits = new int[] {3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4};
        System.out.println(totalFruit(fruits));
    }

    public static int totalFruit(int[] fruits) {
        int l=0;
        int r=0;
        int maxlen = 0;
        Map<Integer, Integer> map = new HashMap<>();
        while(r < fruits.length) {
            map.put(fruits[r], map.getOrDefault(fruits[r], 0) + 1);
            if (map.size() > 2) {
                map.put(fruits[l], map.get(fruits[l]) - 1);
                if (map.get(fruits[l]) == 0) {
                    map.remove(fruits[l]);
                }
                l++;
            }
            if (map.size() <= 2) {
                maxlen = Math.max(maxlen, r - l + 1);
            }
            r++;
        }
        return maxlen;
    }
}
