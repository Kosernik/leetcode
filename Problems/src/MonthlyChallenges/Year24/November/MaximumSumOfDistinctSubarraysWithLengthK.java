package MonthlyChallenges.Year24.November;

import java.util.HashMap;
import java.util.Map;

public class MaximumSumOfDistinctSubarraysWithLengthK {

    /**
     * LeetCode №2461. Maximum Sum of Distinct Subarrays With Length K.
     * <p>
     * Complexity - O(N), N = nums.length, K = k.
     * Memory - O(K)
     *
     * @param nums - an array of integers.
     * @param k    - the length of a subarray.
     * @return - the maximum subarray sum of all the subarrays of nums with the length k and all the elements of the
     * subarray are distinct. If there is no such subarray returns 0.
     */
    public long maximumSubarraySum(int[] nums, int k) {
        long maxSum = 0L;
        long currentSum = 0L;
        Map<Integer, Integer> counts = new HashMap<>();

        for (int i = 0; i < k; i++) {
            int number = nums[i];
            currentSum += number;

            counts.put(number, counts.getOrDefault(number, 0) + 1);
        }

        if (counts.size() == k) {
            maxSum = currentSum;
        }

        for (int i = k; i < nums.length; i++) {
            int number = nums[i];
            int prevNumber = nums[i - k];
            currentSum = currentSum - prevNumber + number;

            counts.put(number, counts.getOrDefault(number, 0) + 1);

            int prevCount = counts.get(prevNumber) - 1;
            if (prevCount == 0) {
                counts.remove(prevNumber);
            } else {
                counts.put(prevNumber, prevCount);
            }

            if (counts.size() == k) {
                maxSum = Math.max(maxSum, currentSum);
            }
        }

        return maxSum;
    }
}
