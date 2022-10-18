package com.blankj.easy._053;

/**
 * <pre>
 *     author: Blankj
 *     blog  : http://blankj.com
 *     time  : 2017/05/04
 *     desc  :
 * </pre>
 */
public class Solution {
    //    public int maxSubArray(int[] nums) {
//        int len = nums.length, dp = nums[0], max = dp;
//        for (int i = 1; i < len; ++i) {
//            dp = nums[i] + (dp > 0 ? dp : 0);
//            if (dp > max) max = dp;
//        }
//        return max;
//    }
    public int maxSubArray(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    private int helper(int[] nums, int left, int right) {
        if (left >= right) return nums[left];
        int mid = (left + right) >> 1;
        int leftAns = helper(nums, left, mid);
        int rightAns = helper(nums, mid + 1, right);
        int leftMax = nums[mid], rightMax = nums[mid + 1];
        int temp = 0;
        for (int i = mid; i >= left; --i) {
            temp += nums[i];
            if (temp > leftMax) leftMax = temp;
        }
        temp = 0;
        for (int i = mid + 1; i <= right; ++i) {
            temp += nums[i];
            if (temp > rightMax) rightMax = temp;
        }
        return Math.max(Math.max(leftAns, rightAns), leftMax + rightMax);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums0 = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(solution.maxSubArray(nums0));
        System.out.println(solution.myMaxSubArray(nums0));
        int[] nums1 = new int[]{2, 7, 9, 3, 1};
        System.out.println(solution.maxSubArray(nums1));
        System.out.println(solution.myMaxSubArray(nums1));
        int[] nums2 = new int[]{-2, 11, -9, 3, 1};
        System.out.println(solution.maxSubArray(nums2));
        System.out.println(solution.myMaxSubArray(nums2));
        int[] nums3 = new int[]{-2, 12, -9, 3, 1};
        System.out.println(solution.maxSubArray(nums3));
        System.out.println(solution.myMaxSubArray(nums3));
    }

    public int myMaxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return Integer.MIN_VALUE;
        }
        int max = Integer.MIN_VALUE;
        int[] f = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                f[i] = nums[i];
            } else {
                if (f[i - 1] > 0) {
                    f[i] = f[i-1] + nums[i];
                } else {
                    f[i] = nums[i];
                }
            }
            if (max < f[i]) {
                max = f[i];
            }
        }

        return max;
    }
}
