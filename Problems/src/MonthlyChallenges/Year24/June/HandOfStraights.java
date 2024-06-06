package MonthlyChallenges.Year24.June;

import java.util.NavigableMap;
import java.util.TreeMap;

public class HandOfStraights {

    /**
     * LeetCode №846. Hand of Straights.
     * <p>
     * Complexity - O(NlogN)
     * Memory - O(N)
     *
     * @param hand      - an array of integers.
     * @param groupSize - the size of a group of consecutive integers.
     * @return - true if it is possible to divide hand-array into sets of groupSize consecutive numbers.
     * False - otherwise.
     */
    public boolean isNStraightHand(int[] hand, int groupSize) {
        NavigableMap<Integer, Integer> sorted = new TreeMap<>();
        for (int number : hand) {
            sorted.put(number, sorted.getOrDefault(number, 0) + 1);
        }

        while (true) {
            if (sorted.isEmpty()) {
                return true;
            }
            if (sorted.size() < groupSize) {
                return false;
            }

            int startNumber = sorted.firstKey();
            decreaseCount(startNumber, sorted);

            for (int i = 1; i < groupSize; i++) {
                if (!sorted.containsKey(startNumber + i)) {
                    return false;
                }

                decreaseCount(startNumber + i, sorted);
            }
        }
    }

    private void decreaseCount(int number, NavigableMap<Integer, Integer> sorted) {
        int count = sorted.get(number);
        if (count == 1) {
            sorted.remove(number);
        } else {
            sorted.put(number, count - 1);
        }
    }
}
