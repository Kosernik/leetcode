package MonthlyChallenges.Year25.April;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountOfInterestingSubarrays {

    /**
     * LeetCode №2845. Count of Interesting Subarrays.
     * <p>
     * Complexity - O(N), N = nums.size(), M = modulo.
     * Memory - O(M)
     *
     * @param nums   - a list of integers.
     * @param modulo - a positive integer.
     * @param k      - an integer, 0 <= k < modulo.
     * @return - the number of interesting subarrays.
     */
    public long countInterestingSubarrays(List<Integer> nums, int modulo, int k) {
        long count = 0L;

        int prefixCount = 0;
        Map<Integer, Integer> remainderCounts = new HashMap<>();
        remainderCounts.put(0, 1);

        for (Integer num : nums) {
            prefixCount += num % modulo == k ? 1 : 0;

            count += remainderCounts.getOrDefault((prefixCount - k + modulo) % modulo, 0);

            int curRemainder = prefixCount % modulo;
            remainderCounts.put(curRemainder, remainderCounts.getOrDefault(curRemainder, 0) + 1);
        }

        return count;
    }
}
