package MonthlyChallenges.Year25.February;

public class MaximumAscendingSubarraySum {

    /**
     * LeetCode №1800. Maximum Ascending Subarray Sum.
     * <p>
     * Complexity - O(N)
     * Memory - O(1)
     *
     * @param nums - an array of integers.
     * @return - the maximum possible sum of an ascending subarray in nums.
     */
    public int maxAscendingSum(int[] nums) {
        int maxSum = 0;
        int curSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= nums[i - 1]) {
                maxSum = Math.max(maxSum, curSum);
                curSum = 0;
            }

            curSum += nums[i];
        }

        maxSum = Math.max(maxSum, curSum);

        return maxSum;
    }
}
