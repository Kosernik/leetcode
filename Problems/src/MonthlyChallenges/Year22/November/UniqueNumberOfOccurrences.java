package MonthlyChallenges.Year22.November;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class UniqueNumberOfOccurrences {

    /**
     * LeetCode #1207. Unique Number of Occurrences.
     * <p>
     * Complexity - O(N)
     * Memory - O(N)
     *
     * @param arr - an array of integers.
     * @return - true if the number of occurrences of each value in the array is unique, or false otherwise.
     */
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> counts = new HashMap<>();
        for (int value : arr) {
            counts.put(value, counts.getOrDefault(value, 0) + 1);
        }

        Set<Integer> uniqueCounts = new HashSet<>();
        for (int count : counts.values()) {
            if (!uniqueCounts.add(count)) {
                return false;
            }
        }

        return true;
    }
}
