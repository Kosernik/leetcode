package MonthlyChallenges.Year25.July;

import java.util.HashSet;
import java.util.Set;

public class MaximumUniqueSubarraySumAfterDeletion {

    /**
     * LeetCode №3487. Maximum Unique Subarray Sum After Deletion.
     * <p>
     * Complexity - O(N)
     * Memory - O(N)
     *
     * @param nums - an array of integers.
     * @return - the maximum sum of resulting subarray.
     */
    public int maxSum(int[] nums) {
        int maxNonpositive = Integer.MIN_VALUE;
        Set<Integer> unique = new HashSet<>();

        int sum = 0;

        for (int number : nums) {
            if (number > 0) {
                if (unique.add(number)) {
                    sum += number;
                }
            } else {
                maxNonpositive = Math.max(maxNonpositive, number);
            }
        }

        if (unique.isEmpty()) return maxNonpositive;
        else return sum;
    }
}
