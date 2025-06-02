package com.problems.arrays_and_strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {
    public static void main(String[] args) {
        int[][] intervals = new int[][] {{1,3},{2,6},{8,10},{15,18}};
        int[][] res = merge(intervals);
        System.out.println(res.length);
    }

    public static int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length <= 1) {
            return intervals;
        }
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        List<int[]> res = new ArrayList<>();
        res.add(intervals[0]);
        for (int i=1;i<intervals.length;i++) {
            int[] currentInterval = intervals[i];
            int[] lastMergedInterval = res.get(res.size() - 1);
            if (currentInterval[0] <= lastMergedInterval[1]) {
                lastMergedInterval[1] = Math.max(lastMergedInterval[1], currentInterval[1]);
            } else {
                res.add(currentInterval);
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}
