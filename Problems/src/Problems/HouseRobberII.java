package Problems;

import java.util.Arrays;

public class HouseRobberII {

    /**
     * LeetCode #213. House Robber II.
     *
     * Complexity - O(N)
     * Memory - O(N)
     *
     * @param nums - an array of non-negative integers.
     * @return - the maximum amount of money you can rob tonight without alerting the police.
     */
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        else if (nums.length == 2) return Math.max(nums[0], nums[1]);

        int[] first = Arrays.copyOfRange(nums, 0, nums.length-1);
        int[] second = Arrays.copyOfRange(nums, 1, nums.length);

        return Math.max(robHelper(first), robHelper(second));
    }

    // LeetCode #198. House Robber.
    public int robHelper(int[] nums) {
        int length = nums.length;
        if (length == 0) {
            return 0;
        } else if (length == 1) {
            return nums[0];
        } else if (length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        int[] dp = new int[length];
        dp[0] = nums[0];
        dp[1] = nums[1];
        dp[2] = Math.max(dp[1], dp[0] + nums[2]);

        for (int i = 3; i < length; i++) {
            int currSum = nums[i] + dp[i-2];
            dp[i] = Math.max(currSum, Math.max(dp[i-1], nums[i] + nums[i-3]));
        }

        return dp[length-1];
    }
}
