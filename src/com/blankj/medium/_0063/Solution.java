package com.blankj.medium._063;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] matrix = new int[][]{
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
        };
        System.out.println(s.uniquePath(matrix));
        matrix = new int[][]{
                {0, 0, 0},
                {0, 0, 0},
                {0, 0, 0}
        };
        System.out.println(s.uniquePath(matrix));
    }

    public int uniquePath(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return -1;
        }

        int m = matrix.length;
        int n = matrix[0].length;

        int[][] f = new int[m][n];
        for (int i = 0; i < m; i++) {
            f[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            f[0][j] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                f[i][j] = 0;
                if (matrix[i][j - 1] == 0) {
                    f[i][j] += f[i][j - 1];
                }
                if (matrix[i - 1][j] == 0) {
                    f[i][j] += f[i - 1][j];
                }
            }
        }
        return f[m - 1][n - 1];
    }
}
