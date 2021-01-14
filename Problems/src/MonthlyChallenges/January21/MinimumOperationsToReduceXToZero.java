package MonthlyChallenges.January21;

import java.util.HashMap;
import java.util.Map;

public class MinimumOperationsToReduceXToZero {
    /**
     * LeetCode #1658.
     *
     * @param nums - array of positive integers.
     * @param x - positive integers.
     * @return - minimum number of elements needed to be removed from array to reduce "x" to 0.
     */
    public int minOperations(int[] nums, int x) {
        int totalSum = 0;

        for (int n : nums) totalSum += n;
        if (totalSum == x) return nums.length;

        int length = lengthOfLongestSubarray(nums, totalSum - x);
        if (length == 0) return -1;
        return nums.length - length;
    }

    private int lengthOfLongestSubarray (int[] nums, int target) {
        Map<Integer, Integer> indexes = new HashMap<>();
        int sum = 0;
        int maxLength = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum == target) maxLength = i+1;

            if (!indexes.containsKey(sum)) indexes.put(sum, i);

            if (indexes.containsKey(sum-target)) {
                if (maxLength < (i - indexes.get(sum - target))) {
                    maxLength = i - indexes.get(sum - target);
                }
            }
        }

        return maxLength;
    }
}
