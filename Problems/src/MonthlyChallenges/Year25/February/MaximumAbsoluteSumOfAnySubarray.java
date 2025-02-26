package MonthlyChallenges.Year25.February;

public class MaximumAbsoluteSumOfAnySubarray {

    /**
     * LeetCode №1749. Maximum Absolute Sum of Any Subarray.
     * <p>
     * Complexity - O(N)
     * Memory - O(1)
     *
     * @param nums - an array of integers.
     * @return - the maximum absolute sum of any (possibly empty) subarray of nums.
     */
    public int maxAbsoluteSum(int[] nums) {
        int maxSum = 0;
        int minSum = 0;
        int curMinSum = 0;
        int curMaxSum = 0;

        for (int number : nums) {
            curMinSum = Math.min(number, curMinSum + number);
            curMaxSum = Math.max(number, curMaxSum + number);

            minSum = Math.min(minSum, curMinSum);
            maxSum = Math.max(maxSum, curMaxSum);
        }

        return Math.max(maxSum, Math.abs(minSum));
    }
}
