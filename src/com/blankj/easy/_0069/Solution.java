package com.blankj.easy._069;

/**
 * <pre>
 *     author: Blankj
 *     blog  : http://blankj.com
 *     time  : 2017/05/08
 *     desc  :
 * </pre>
 */
public class Solution {
    public int mySqrt(int x) {
        long n = x;
        while (n * n > x) {
            n = (n + x / n) >> 1;
        }
        return (int) n;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.mySqrt(10));
        System.out.println(solution.sqrt(10));
        System.out.println(solution.sqrt2(10));
        System.out.println(solution.mySqrt(4));
        System.out.println(solution.sqrt(4));
        System.out.println(solution.sqrt2(4));
        System.out.println(solution.mySqrt(3));
        System.out.println(solution.sqrt(3));
        System.out.println(solution.sqrt2(3));
        System.out.println(solution.mySqrt(100));
        System.out.println(solution.sqrt(100));
        System.out.println(solution.sqrt2(100));

    }

    public int sqrt(int x) {
        if (x <= 0) {
            return 0;
        }
        for (int i = 0; i < x/2; i++) {
            if (i * i <= x && (i + 1) * (i * 1) > x) {
                return i;
            }
        }

        return x/2;
    }

    public int sqrt2(int x) {
        if (x <= 0) {
            return 0;
        }
        int low = 0;
        int high = x/2;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (mid*mid == x) {
                return mid;
            } else if (mid*mid < x) {
                if (low == mid) {
                    if (high * high > x) {
                        return mid;
                    } else {
                        return high;
                    }
                }
                low = mid;
            } else {
                high = mid;
            }
        }

        return -1;
    }
}
