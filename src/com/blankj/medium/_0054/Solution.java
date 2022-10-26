import java.util.List;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(List.of(s.spiralTravel(new int[][]{{1, 2, 3}, {4, 5, 6}})));
        System.out.println(List.of(s.spiralTravel(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}})));
        System.out.println(List.of(s.spiralTravel(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}})));
    }

    public Integer[] spiralTravel(int[][] numsArray) {
        if (numsArray == null || numsArray.length == 0 || numsArray[0] == null) {
            return null;
        }
        int total = 0;
        int length = numsArray[0].length;
        for (int[] nums : numsArray) {
            if (nums == null) {
                throw new IllegalArgumentException("have null arrays");
            }
            if (nums.length != length) {
                throw new IllegalArgumentException("not have same length");
            }
            total += nums.length;
        }
        int top = 0, left = numsArray[0].length, bottom = numsArray.length, right = 0;
        int count = 0;
        Integer[] res = new Integer[total];
        while (count < total) {
            int j = top;
            int i = right;
            for (; i < left; i++) {
                res[count++] = numsArray[j][i];
            }
            i = left - 1;
            for (j = top + 1; j < bottom; j++) {
                res[count++] = numsArray[j][i];
            }
            j = bottom - 1;
            for (i = left - 2; i >= right; i--) {
                res[count++] = numsArray[j][i];
            }
            i = right;
            for (j = bottom - 2; j > top; j--) {
                res[count++] = numsArray[j][i];
            }
            top = top + 1;
            left = left - 1;
            bottom = bottom -1;
            right = right + 1;
        }

        return res;
    }
}
