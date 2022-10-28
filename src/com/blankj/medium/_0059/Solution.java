package com.blankj.medium._059;


public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        s.displayMatrix(s.generateSpiralMatrix(3));
        s.displayMatrix(s.generateSpiralMatrix(4));
    }

    private void displayMatrix(int[][] matrix) {
        for (int[] column : matrix) {
            for (int e : column) {
                System.out.print(e);
                System.out.print(" ");
            }
            System.out.println("\n");
        }
    }

    public int[][] generateSpiralMatrix(int n) {
        int[][] res = new int[n][n];
        int count = 1;
        int top = 0;
        int right = 0;
        int left = n;
        int bottom = n;
        int total = n * n;
        while (count <= total) {
            int i = top;
            int j = right;
            for (; j < left; j++) {
                res[i][j] = count++;
            }
            j = left - 1;
            for (i = top + 1; i < bottom; i++) {
                res[i][j] = count++;
            }
            i = bottom - 1;
            for (j = left - 2; j >= right; j--) {
                res[i][j] = count++;
            }
            j = right;
            for (i = bottom - 2; i > top; i--) {
                res[i][j] = count++;
            }
            top = top + 1;
            left = left - 1;
            bottom = bottom - 1;
            right = right + 1;
        }

        return res;
    }
}
