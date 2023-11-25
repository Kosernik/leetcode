package MonthlyChallenges.Year23.November;

public class SumOfAbsoluteDifferencesInSortedArray {

    /**
     * LeetCode №1685. Sum of Absolute Differences in a Sorted Array.
     * <p>
     * Complexity - O(N)
     * Memory - O(N)
     *
     * @param nums - an array of positive integers sorted in non-decreasing order.
     * @return - the resulting array.
     */
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int length = nums.length;
        int[] result = new int[length];

        int[] postfixSum = new int[length];
        postfixSum[length - 1] = nums[length - 1];

        for (int i = length - 2; i >= 0; i--) {
            postfixSum[i] = postfixSum[i + 1] + nums[i];
        }
        int totalSum = postfixSum[0];

        for (int i = 0; i < length; i++) {
            result[i] = postfixSum[i] - nums[i] * (length - i) - (totalSum - postfixSum[i] - nums[i] * i);
        }

        return result;
    }
}
