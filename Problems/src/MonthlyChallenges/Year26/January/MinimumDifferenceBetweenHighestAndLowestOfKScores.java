package MonthlyChallenges.Year26.January;

import java.util.Arrays;

public class MinimumDifferenceBetweenHighestAndLowestOfKScores {

    /**
     * LeetCode №1984. Minimum Difference Between Highest and Lowest of K Scores.
     * <p>
     * Complexity - O(NlogN)
     * Memory - O(1) * Depends on sorting algorithm complexity.
     *
     * @param nums - an array of integers.
     * @param k    - the required number of values
     * @return - the minimum possible difference between the highest and the lowest values after picking any k-values
     * from nums.
     */
    public int minimumDifference(int[] nums, int k) {
        if (k == 1) return 0;

        Arrays.sort(nums);

        int minDiff = Integer.MAX_VALUE;

        for (int i = 0, j = k - 1; j < nums.length; i++, j++) {
            minDiff = Math.min(minDiff, nums[j] - nums[i]);
        }

        return minDiff;
    }
}
