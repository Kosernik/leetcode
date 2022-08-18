package MonthlyChallenges.Year22.August;

import java.util.*;

public class ReduceArraySizeToHalf {

    /**
     * LeetCode #1338. Reduce Array Size to The Half.
     * <p>
     * Complexity - O(N + NlogN)
     * Memory - O(N)
     *
     * @param arr - an array of integers. arr.length is even.
     * @return -the minimum size of the set of integers to be deleted so that at least half of the integers of the array
     * are removed.
     */
    public int minSetSize(int[] arr) {
        Map<Integer, Integer> counts = new HashMap<>();

        for (int number : arr) {
            counts.put(number, counts.getOrDefault(number, 0) + 1);
        }

        List<Integer> numberOfOccurrences = new ArrayList<>(counts.values());
        numberOfOccurrences.sort(Collections.reverseOrder());

        int result = 0;
        int numberOfDeletedElements = 0;
        int halfSize = arr.length / 2;

        for (Integer occurrence : numberOfOccurrences) {
            result++;
            numberOfDeletedElements += occurrence;

            if (numberOfDeletedElements >= halfSize) break;
        }

        return result;
    }
}
