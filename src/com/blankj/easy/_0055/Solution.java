public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.canJump2End(new int[]{1, 2, 3, 4}));
        System.out.println(solution.canJump2End(new int[]{3, 1, 0, 4}));
        System.out.println(solution.canJump2End(new int[]{3, 2, 1, 0, 4}));
        System.out.println(solution.canJump2End(new int[]{2, 3, 1, 1, 4}));
    }

    public boolean canJump2End(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int step = 1;
        int index = 0;
        while (index < nums.length && step > 0) {
            step = nums[index];
            int maxIndex = index;
            int maxStep = index;
            for (int i = 1; i <= step; i++) {
                if (index + i >= nums.length) {
                    return true;
                }
                if (nums[index + i] + index + i > maxStep) {
                    maxIndex = index + i;
                    maxStep = nums[index + i] + index + i;
                }
            }
            index = maxIndex;
            step = nums[maxIndex];
        }
        if (step == 0) {
            return false;
        }

        return true;
    }
}
