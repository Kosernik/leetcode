package MonthlyChallenges.Year24.November;

import java.util.Arrays;

public class CountNumberOfFairPairs {

    /**
     * LeetCode №2563. Count the Number of Fair Pairs.
     * <p>
     * Complexity - O(NlogN) - N = nums.length.
     * Memory - O(sorting complexity)
     *
     * @param nums  - an array of integers.
     * @param lower - the lower valid sum of a fair pair (inclusive).
     * @param upper - the upper valid sum of a fair pair (inclusive).
     * @return - the total number of fair pairs.
     */
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);

        long result = 0;

        for (int i = 0; i < nums.length; i++) {
            int number = nums[i];

            int lowerTarget = lower - number;
            int upperTarget = upper - number;

            if (upperTarget < number) break;

            int lowerIdx = Math.max(binarySearch(lowerTarget - 1, nums), i);
            int upperIdx = binarySearch(upperTarget, nums);

            result += upperIdx - lowerIdx;
        }

        return result;
    }

    private int binarySearch(int target, int[] nums) {
        int left = 0, right = nums.length, middle;

        while (left < right) {
            middle = (right - left) / 2 + left;

            if (nums[middle] <= target) {
                left = middle + 1;
            } else {
                right = middle;
            }
        }

        return right - 1;
    }
}
