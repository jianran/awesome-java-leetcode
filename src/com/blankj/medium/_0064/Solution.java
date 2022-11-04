package com.blankj.medium._064;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] matrix = new int[][]{
                {1,3,1},
                {1,5,1},
                {4,2,1}
        };
        System.out.println(s.minimumPath(matrix));
        matrix = new int[][]{
                {1,3,1},
                {1,5,4},
                {4,2,1}
        };
        System.out.println(s.minimumPath(matrix));
    }

    public int minimumPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return -1;
        }

        int m = matrix.length;
        int n = matrix[0].length;

        int[][] f = new int[m][n];
        f[0][0] = matrix[0][0];
        for (int i = 1; i < m; i++) {
            f[i][0] = f[i - 1][0] + matrix[i][0];
        }
        for (int j = 1; j < n; j++) {
            f[0][j] = f[0][j - 1] + matrix[0][j];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (f[i - 1][j] > f[i][j - 1]) {
                    f[i][j] = f[i][j - 1] + matrix[i][j];
                } else {
                    f[i][j] = f[i - 1][j] + matrix[i][j];
                }
            }
        }
        return f[m - 1][n - 1];
    }
}
