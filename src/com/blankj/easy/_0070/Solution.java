package com.blankj.easy._070;

/**
 * <pre>
 *     author: Blankj
 *     blog  : http://blankj.com
 *     time  : 2017/05/09
 *     desc  :
 * </pre>
 */
public class Solution {
    public int climbStairs(int n) {
        int a = 1, b = 1;
        while (--n > 0) {
            b += a;
            a = b - a;
        }
        return b;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.climbStairs(3));
        System.out.println(solution.myClimbStairs(3));
        System.out.println(solution.myClimbStairs2(3));
        System.out.println(solution.myClimbStairs3(3));
        System.out.println(solution.climbStairs(4));
        System.out.println(solution.myClimbStairs(4));
        System.out.println(solution.myClimbStairs2(4));
        System.out.println(solution.myClimbStairs3(4));
    }

    public int myClimbStairs(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        return myClimbStairs(n - 1) + myClimbStairs(n - 2);
    }

    public int myClimbStairs2(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int[] f = new int[n];
        f[0] = 1;
        f[1] = 2;
        for (int i = 2; i < n; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }

        return f[n - 1];
    }

    public int myClimbStairs3(int n) {
        if (n <= 0) {
            return 0;
        }
        int f0 = 1;
        int f1 = 1;
        while (--n > 0) {
            int tmp = f1;
            f1 = f1 + f0;
            f0 = tmp;
        }
        return f1;
    }
}
