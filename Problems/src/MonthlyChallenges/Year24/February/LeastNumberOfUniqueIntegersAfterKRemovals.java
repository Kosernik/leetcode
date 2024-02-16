package MonthlyChallenges.Year24.February;

import java.util.*;

public class LeastNumberOfUniqueIntegersAfterKRemovals {
    public static void main(String[] args) {
        LeastNumberOfUniqueIntegersAfterKRemovals solution = new LeastNumberOfUniqueIntegersAfterKRemovals();

        int[] testArr = {2, 4, 1, 8, 3, 5, 1, 3};
        int testK = 3;

        System.out.println(solution.findLeastNumOfUniqueInts(testArr, testK) == 3);
    }

    /**
     * LeetCode №1481. Least Number of Unique Integers after K Removals.
     * <p>
     * Complexity
     * Memory
     *
     * @param arr - an array of integers.
     * @param k   - the number of removes.
     * @return - the least number of unique integers after removing exactly k elements.
     */
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> elements = new HashMap<>();
        for (int number : arr) {
            elements.put(number, elements.getOrDefault(number, 0) + 1);
        }

        List<Integer> counts = new ArrayList<>(elements.values());
        Collections.sort(counts);

        int removed = 0;
        for (int count : counts) {
            if (k - count < 0) {
                break;
            } else {
                removed++;
                k -= count;
            }
        }

        return counts.size() - removed;
    }
}
