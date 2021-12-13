package Problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class NumberOfLongestIncreasingSubsequence {

    /**
     * LeetCode #673. Number of Longest Increasing Subsequence.
     *
     * Complexity - O(N^2)
     * Memory - O(N)
     *
     * @param nums - an array of positive integers.
     * @return - the number of the longest increasing subsequences.
     */
    public int findNumberOfLIS(int[] nums) {
        int maxLength = 1;

        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int[] countLengths = new int[nums.length];
        Arrays.fill(countLengths, 1);

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    if (dp[i] == dp[j]+1) {
                        countLengths[i] += countLengths[j];
                    } else if (dp[i] < dp[j]+1) {
                        dp[i] =  dp[j] + 1;
                        countLengths[i] = countLengths[j];
                    }
                    maxLength = Math.max(maxLength, dp[i]);
                }
            }
        }

        int result = 0;
        for (int i = 0; i < dp.length; i++) {
            if (dp[i] == maxLength) result += countLengths[i];
        }
        return result;
    }
}
