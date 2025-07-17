package MonthlyChallenges.Year25.July;

public class FindMaximumLengthOfValidSubsequenceII {

    /**
     * LeetCode №3202. Find the Maximum Length of Valid Subsequence II.
     *
     * @param nums - an array of positive integers.
     * @param k    - a positive integer.
     * @return - the length of the longest valid subsequence of nums.
     */
    public int maximumLength(int[] nums, int k) {
        int length = 0;

        int[][] dp = new int[k][k];

        for (int num : nums) {
            int remainder = num % k;

            for (int j = 0; j < k; j++) {
                dp[j][remainder] = dp[remainder][j] + 1;

                length = Math.max(length, dp[j][remainder]);
            }
        }

        return length;
    }
}
