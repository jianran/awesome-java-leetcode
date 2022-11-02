package com.blankj.medium._062;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.uniquePath(3, 2));
        System.out.println(s.uniquePath(7, 3));
    }

    public int uniquePath(int m, int n) {
        if (m <= 0 || n <= 0) {
            return -1;
        }

        int[][] f = new int[m][n];
        for (int i = 0; i < m; i++) {
            f[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            f[0][j] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                f[i][j] = f[i][j - 1] + f[i - 1][j];
            }
        }
        return f[m - 1][n - 1];
    }
}
