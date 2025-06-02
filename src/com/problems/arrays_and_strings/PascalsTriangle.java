package com.problems.arrays_and_strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalsTriangle {
    public static void main(String[] args) {
        int numRows = 5;
        List<List<Integer>> res = generate(numRows);
        System.out.println(res.size());
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(Arrays.asList(1));
        if (numRows == 1) {
            return result;
        }
        result.add(Arrays.asList(1, 1));
        if (numRows == 2) {
            return result;
        }
        for(int i = 2;i<numRows;i++) {
            List<Integer> row = new ArrayList<>();
            for(int j=0;j<=i;j++) {
                if (j==0 || j==i) {
                    row.add(1);
                } else {
                    row.add(result.get(i-1).get(j) + result.get(i-1).get(j-1));
                }
            }
            result.add(row);
        }
        return result;
    }
}
