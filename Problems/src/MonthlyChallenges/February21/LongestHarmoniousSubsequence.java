package MonthlyChallenges.February21;

import java.util.HashMap;
import java.util.Map;

public class LongestHarmoniousSubsequence {
    /**
     * LeetCode #594.
     *
     * Returns the length of the longest harmonious series.
     *
     * Complexity - O(N)
     * Memory - O(N)
     *
     * @param nums - array of integers, not empty.
     * @return - the length of the longest harmonious series.
     */
    public int findLHS(int[] nums) {
        Map<Integer, Integer> counts = new HashMap<>();
        for (int number : nums) {
            counts.put(number, counts.getOrDefault(number, 0)+1);
        }

        int longestSeries = 0;

        for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
            int currCount = entry.getValue();

            if (counts.containsKey(entry.getKey()-1)) {
                longestSeries = Math.max(longestSeries, currCount + counts.get(entry.getKey()-1));
            }
            if (counts.containsKey(entry.getKey()+1)) {
                longestSeries = Math.max(longestSeries, currCount + counts.get(entry.getKey()+1));
            }
        }

        return longestSeries;
    }
}
