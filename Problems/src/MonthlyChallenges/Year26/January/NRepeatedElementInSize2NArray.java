package MonthlyChallenges.Year26.January;

import java.util.HashMap;
import java.util.Map;

public class NRepeatedElementInSize2NArray {

    /**
     * LeetCode №961. N-Repeated Element in Size 2N Array.
     * <p>
     * Complexity - O(M), M = nums.length.
     * Memory - O(M)
     *
     * @param nums - an array of integers of length n*2.
     * @return - the element that is repeated n times
     */
    public int repeatedNTimes(int[] nums) {
        int targetLength = nums.length / 2;
        Map<Integer, Integer> counts = new HashMap<>();

        for (int number : nums) {
            counts.put(number, counts.getOrDefault(number, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
            if (entry.getValue() >= targetLength) return entry.getKey();
        }

        return nums[0];
    }
}
