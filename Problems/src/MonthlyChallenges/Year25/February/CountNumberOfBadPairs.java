package MonthlyChallenges.Year25.February;

import java.util.HashMap;
import java.util.Map;

public class CountNumberOfBadPairs {

    /**
     * LeetCode №2364. Count Number of Bad Pairs.
     * <p>
     * Complexity - O(N)
     * Memory - O(N)
     * <p>
     * A pair of indices (i, j) is a bad pair if i < j and j - i != nums[j] - nums[i].
     *
     * @param nums - an array of integers.
     * @return - the total number of bad pairs in nums.
     */
    public long countBadPairs(int[] nums) {
        long goodPairs = 0L;

        long length = nums.length;
        Map<Integer, Integer> counts = new HashMap<>();

        for (int i = 0; i < length; i++) {
            int diff = nums[i] - i;

            int prevCount = counts.getOrDefault(diff, 0);

            goodPairs += prevCount;

            counts.put(diff, prevCount + 1);
        }

        return length * (length - 1) / 2 - goodPairs;
    }
}
