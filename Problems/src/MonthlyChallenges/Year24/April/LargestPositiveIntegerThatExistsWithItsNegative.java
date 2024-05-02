package MonthlyChallenges.Year24.April;

import java.util.Arrays;

public class LargestPositiveIntegerThatExistsWithItsNegative {

    /**
     * LeetCode №2441. Largest Positive Integer That Exists With Its Negative.
     * <p>
     * Complexity - O(NlogN)
     * Memory - O(1) + sorting algorithm memory usage.
     *
     * @param nums - an array of integers that does not contain any zeros.
     * @return - the largest positive integer k such that -k also exists in the array, or -1 if there is no such integer.
     */
    public int findMaxK(int[] nums) {
        Arrays.sort(nums);

        for (int i = nums.length - 1; i > 0; i--) {
            int curNumber = nums[i];
            int negative = -1 * curNumber;
            int idx = Arrays.binarySearch(nums, negative);
            if (idx >= 0) {
                return curNumber;
            }
        }

        return -1;
    }
}
