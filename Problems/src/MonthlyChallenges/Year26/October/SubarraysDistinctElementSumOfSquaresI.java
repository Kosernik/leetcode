package MonthlyChallenges.Year26.October;

import java.util.Arrays;
import java.util.List;

public class SubarraysDistinctElementSumOfSquaresI {

    /**
     * LeetCode №2913. Subarrays Distinct Element Sum of Squares I.
     * <p>
     * Complexity - O(N^2), N = nums.size(), M = max element in nums.
     * Memory - O(M)
     * <p>
     * The distinct count of a subarray of nums is defined as:
     * *    Let nums[i..j] be a subarray of nums consisting of all the indices from i to j such that
     * *    0 <= i <= j < nums.size(). Then the number of distinct values in nums[i..j] is called the distinct count
     * *    of nums[i..j].
     *
     * @param nums - an array of positive integers. 1 <= nums[i] <= 100
     * @return - the sum of the squares of distinct counts of all subarrays of nums.
     */
    public int sumCounts(List<Integer> nums) {
        int result = 0;

        int[] uniques = new int[101];
        int uniqueCount;

        for (int i = 0; i < nums.size(); i++) {
            Arrays.fill(uniques, 0);
            uniqueCount = 0;

            for (int j = i; j < nums.size(); j++) {
                uniques[nums.get(j)]++;

                if (uniques[nums.get(j)] == 1) {
                    uniqueCount++;
                }

                result += uniqueCount * uniqueCount;
            }
        }

        return result;
    }
}
