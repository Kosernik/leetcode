package MonthlyChallenges.Year26.August;

import java.util.Arrays;

public class SmallestMissingIntegerGreaterThanSequentialPrefixSum {

    /**
     * LeetCode №2996. Smallest Missing Integer Greater Than Sequential Prefix Sum.
     * <p>
     * Complexity - O(NlogN)
     * Memory - O(logN)
     * <p>
     * * A prefix nums[0..i] is sequential if, for all 1 <= j <= i, nums[j] = nums[j - 1] + 1. In particular, the prefix
     * consisting only of nums[0] is sequential.
     *
     * @param nums - an array of positive integers.
     * @return - the smallest integer x missing from nums such that x is greater than or equal to the sum of the longest
     * sequential prefix.
     */
    public int missingInteger(int[] nums) {
        int sum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != (nums[i - 1] + 1)) {
                break;
            }

            sum += nums[i];
        }

        Arrays.sort(nums);

        int idx = Arrays.binarySearch(nums, sum);

        if (idx < 0) {
            return sum;
        }

        int result = sum + 1;
        for (int i = idx + 1; i < nums.length; i++) {
            if (nums[i] > result) {
                return result;
            }
            result = nums[i] + 1;
        }

        return result;
    }
}
