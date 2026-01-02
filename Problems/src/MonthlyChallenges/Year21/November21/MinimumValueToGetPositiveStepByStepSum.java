package MonthlyChallenges.Year21.November21;

public class MinimumValueToGetPositiveStepByStepSum {

    /**
     * LeetCode #1413. Minimum Value to Get Positive Step by Step Sum.
     * <p>
     * Complexity - O(N)
     * Memory - O(1)
     *
     * @param nums - an array of integers.
     * @return - the minimum positive value of startValue such that the step by step sum is never less than 1.
     */
    public int minStartValue(int[] nums) {
        int curSum = 0;
        int minSum = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            curSum += nums[i];
            minSum = Math.min(minSum, curSum);
        }

        if (minSum >= 0) return 1;
        else return (-minSum + 1);
    }
}
