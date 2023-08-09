package MonthlyChallenges.Year23.August;

import java.util.Arrays;

public class MinimizeMaximumDifferenceOfPairs {

    /**
     * LeetCode #2616. Minimize the Maximum Difference of Pairs.
     * <p>
     * Complexity - O(NlogN)
     * Memory - O(1)
     *
     * @param nums - an array of non-negative integers.
     * @param p    - the number of pairs.
     * @return - the minimum maximum difference among all p pairs.
     */
    public int minimizeMax(int[] nums, int p) {
        Arrays.sort(nums);

        int left = 0, right = nums[nums.length - 1] - nums[0], middle;

        while (left < right) {
            middle = (right - left) / 2 + left;

            if (numberOfValidPairs(middle, nums) >= p) {
                right = middle;
            } else {
                left = middle + 1;
            }
        }

        return left;
    }

    private int numberOfValidPairs(int difference, int[] nums) {
        int numberOfValidPairs = 0;
        int idx = 1;

        while (idx < nums.length) {
            if (nums[idx] - nums[idx - 1] <= difference) {
                idx++;
                numberOfValidPairs++;
            }
            idx++;
        }

        return numberOfValidPairs;
    }

    /**
     * LeetCode #2616. Minimize the Maximum Difference of Pairs.
     *
     * @param nums - an array of non-negative integers.
     * @param p    - the number of pairs.
     * @return - the minimum maximum difference among all p pairs.
     */
    public int minimizeMaxMemoryLimitExceeded(int[] nums, int p) {
        Arrays.sort(nums);

        int[][] dp = new int[nums.length + 1][p + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return helper(0, nums, p, dp);
    }

    private int helper(int idx, int[] nums, int p, int[][] dp) {
        // no more pairs left -> 0
        if (p == 0) {
            return 0;
        }
        // index out of range (+ next neighbour) -> Integer.MAX_VALUE
        else if (idx + 1 >= nums.length) {
            return Integer.MAX_VALUE;
        }
        // return already computed -> dp[idx][p]
        else if (dp[idx][p] != -1) {
            return dp[idx][p];
        }

        int pickCurrent = Math.max((nums[idx + 1] - nums[idx]), helper(idx + 2, nums, p - 1, dp));
        int ignoreCurrent = helper(idx + 1, nums, p, dp);

        dp[idx][p] = Math.min(pickCurrent, ignoreCurrent);
        return dp[idx][p];
    }
}
