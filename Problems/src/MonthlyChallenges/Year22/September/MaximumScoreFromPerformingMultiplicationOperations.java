package MonthlyChallenges.Year22.September;

public class MaximumScoreFromPerformingMultiplicationOperations {

    /**
     * LeetCode #1770. Maximum Score from Performing Multiplication Operations.
     * <p>
     * Complexity - O(M^2), M = multipliers.length.
     * Memory - O(M)
     *
     * @param nums        - an array of integers.
     * @param multipliers - an array of integers.
     * @return - the maximum score.
     */
    public int maximumScore(int[] nums, int[] multipliers) {
        int n = nums.length;
        int[] dp = new int[multipliers.length + 1];

        for (int i = multipliers.length - 1; i >= 0; i--) {
            int[] prev_row = dp.clone();

            for (int left = i; left >= 0; left--) {
                dp[left] = Math.max(
                        multipliers[i] * nums[left] + prev_row[left + 1],
                        multipliers[i] * nums[n - 1 - (i - left)] + prev_row[left]
                );
            }
        }

        return dp[0];
    }
}
