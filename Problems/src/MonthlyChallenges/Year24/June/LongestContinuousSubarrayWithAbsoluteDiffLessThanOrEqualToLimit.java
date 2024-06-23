package MonthlyChallenges.Year24.June;

import java.util.TreeMap;

public class LongestContinuousSubarrayWithAbsoluteDiffLessThanOrEqualToLimit {
    public static void main(String[] args) {
        LongestContinuousSubarrayWithAbsoluteDiffLessThanOrEqualToLimit solution = new LongestContinuousSubarrayWithAbsoluteDiffLessThanOrEqualToLimit();

        int[] testNums1 = {10, 1, 2, 4, 7, 2};
        int testLimit1 = 5;
        System.out.println(solution.longestSubarray(testNums1, testLimit1) == 4);

    }

    /**
     * LeetCode №1438. Longest Continuous Subarray With Absolute Diff Less Than or Equal to Limit
     * <p>
     * Complexity - O(NlogN)
     * Memory - O(N)
     *
     * @param nums  - an array of integers.
     * @param limit - the maximum absolute difference between any two numbers in a subarray.
     * @return - the size of the longest non-empty subarray such that the absolute difference between any two elements
     * of this subarray is less than or equal to limit.
     */
    public int longestSubarray(int[] nums, int limit) {
        int result = 0;

        TreeMap<Integer, Integer> counts = new TreeMap<>();
        int left = 0;

        for (int right = 0; right < nums.length; right++) {
            counts.put(nums[right], counts.getOrDefault(nums[right], 0) + 1);

            while ((counts.lastKey() - counts.firstKey()) > limit) {
                counts.put(nums[left], counts.get(nums[left]) - 1);
                if (counts.get(nums[left]) == 0) {
                    counts.remove(nums[left]);
                }

                left++;
            }

            result = Math.max(result, right - left + 1);
        }

        return result;
    }
}
