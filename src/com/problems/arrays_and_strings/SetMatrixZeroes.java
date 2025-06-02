package com.problems.arrays_and_strings;

import java.util.HashSet;
import java.util.Set;

public class SetMatrixZeroes {
    public static void main(String[] args) {
        int[][] matrix = new int[][] {{1,1,1},{1,0,1},{1,1,1}};
        setZeroes(matrix);
    }

    public static void setZeroes(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        for(int i = 0;i<row;i++) {
            for(int j=0;j<col;j++) {
                if(matrix[i][j] == 0) {
                    set1.add(i);
                    set2.add(j);
                }
            }
        }

        for(int i=0;i<row;i++) {
            for(int j=0;j<col;j++) {
                if(set1.contains(i) || set2.contains(j)) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    public static void setZeroes_2(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean firstRowZero = false, firstColZero = false;
        for(int j=0;j<n;j++) {
            if(matrix[0][j] == 0) {
                firstRowZero = true;
                break;
            }
        }

        for (int i=0;i<m;i++) {
            if(matrix[i][0] == 0) {
                firstColZero = true;
                break;
            }
        }

        for(int i=1;i<m;i++) {
            for (int j=1;j<n;j++) {
                if(matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        if (firstRowZero) {
            for (int j = 0; j < n; j++) matrix[0][j] = 0;
        }

        if (firstColZero) {
            for (int i = 0; i < m; i++) matrix[i][0] = 0;
        }
    }
}
