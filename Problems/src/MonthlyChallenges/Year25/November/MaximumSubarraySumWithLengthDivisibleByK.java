package MonthlyChallenges.Year25.November;

public class MaximumSubarraySumWithLengthDivisibleByK {

    /**
     * LeetCode №3381. Maximum Subarray Sum With Length Divisible by K.
     * <p>
     * Complexity - O(N)
     * Memory - O(K)
     *
     * @param nums - an array of integers.
     * @param k    - a positive integer.
     * @return - the maximum sum of a subarray of nums, such that the size of the subarray is divisible by k.
     */
    public long maxSubarraySum(int[] nums, int k) {
        long[] prefix = new long[k];

        long curSum = 0;
        for (int i = 0; i < k; i++) {
            curSum += nums[i];
        }

        prefix[0] = curSum;

        long maxSum = curSum;

        for (int i = k, prefIdx = 1 % k;
             i < nums.length;
             i++, prefIdx = (prefIdx + 1) % k
        ) {
            curSum = curSum - nums[i - k] + nums[i];

            if (prefix[prefIdx] < 0) {
                prefix[prefIdx] = curSum;
            } else {
                prefix[prefIdx] += curSum;
            }

            maxSum = Math.max(maxSum, prefix[prefIdx]);
        }

        return maxSum;
    }
}
