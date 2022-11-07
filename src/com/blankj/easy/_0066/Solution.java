package com.blankj.easy._066;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <pre>
 *     author: Blankj
 *     blog  : http://blankj.com
 *     time  : 2017/05/06
 *     desc  :
 * </pre>
 */
public class Solution {
    public int[] plusOne(int[] digits) {
        int p = digits.length - 1;
        if (digits[p] < 9) {
            digits[p] = ++digits[p];
        } else {
            do {
                digits[p--] = 0;
            } while (p >= 0 && digits[p] == 9);
            if (digits[0] != 0) {
                ++digits[p];
            } else {
                digits = new int[digits.length + 1];
                digits[0] = 1;
            }
        }
        return digits;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] digits = solution.plusOne(new int[]{9, 9, 9});
        System.out.println(Arrays.toString(digits));
        digits = solution.myPlusOne(new int[]{9, 9, 9});
        System.out.println(Arrays.toString(digits));
        digits = solution.myPlusOne2(new int[]{9, 9, 9});
        System.out.println(Arrays.toString(digits));
        digits = solution.myPlusOne2(new int[]{8, 9, 9});
        System.out.println(Arrays.toString(digits));
        digits = solution.myPlusOne2(new int[]{8, 9, 8});
        System.out.println(Arrays.toString(digits));

    }

    public int[] myPlusOne(int[] digits) {
        if (digits == null || digits.length == 0) {
            return null;
        }
        int[] res = new int[digits.length];
        int carry = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            res[i] = (digits[i] + carry) % 10;
            carry = (digits[i] + carry) / 10;
        }
        if (carry > 0) {
            int[] tmp = new int[digits.length + 1];
            tmp[0] = carry;
            for (int i = 0; i < res.length; i++) {
                tmp[i + 1] = res[i];
            }
            res = tmp;
        }

        return res;
    }

    public int[] myPlusOne2(int[] digits) {
        if (digits == null || digits.length == 0) {
            return null;
        }
        int i = digits.length - 1;
        for (; i >= 0; i--) {
            if (digits[i] == 9) {
                digits[i] = 0;
            } else {
                break;
            }
        }
        if (i < 0) {
            digits = new int[digits.length + 1];
            digits[0] = 1;
        } else {
            digits[i] ++;
        }
        return digits;
    }
}
