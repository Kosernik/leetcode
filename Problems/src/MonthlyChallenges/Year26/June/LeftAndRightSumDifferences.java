package MonthlyChallenges.Year26.June;

public class LeftAndRightSumDifferences {

    /**
     * LeetCode №2574. Left and Right Sum Differences.
     * <p>
     * Complexity - O(N)
     * Memory - O(1)
     *
     * @param nums - an array of integers.
     * @return - an array of differences of prefix and postfix sums.
     */
    public int[] leftRightDifference(int[] nums) {
        int[] result = new int[nums.length];

        for (int i = 1; i < nums.length; i++) {
            result[i] = result[i - 1] + nums[i - 1];
        }

        for (int i = nums.length - 2, curSum = nums[nums.length - 1]; i >= 0; i--) {
            result[i] = Math.abs(result[i] - curSum);

            curSum += nums[i];
        }

        return result;
    }
}
