package MonthlyChallenges.Year24.June;

import java.util.NavigableMap;
import java.util.TreeMap;

public class DivideArrayInSetsOfKConsecutiveNumbers {

    /**
     * LeetCode №1296. Divide Array in Sets of K Consecutive Numbers.
     * <p>
     * Complexity - O(NlogN)
     * Memory - O(N)
     *
     * @param nums - an array of integers.
     * @param k    - the size of a group of consecutive integers.
     * @return - true if it is possible to divide hand-array into sets of groupSize consecutive numbers.
     * False - otherwise.
     */
    public boolean isPossibleDivide(int[] nums, int k) {
        NavigableMap<Integer, Integer> sorted = new TreeMap<>();
        for (int number : nums) {
            sorted.put(number, sorted.getOrDefault(number, 0) + 1);
        }

        while (true) {
            if (sorted.isEmpty()) {
                return true;
            }
            if (sorted.size() < k) {
                return false;
            }

            int startNumber = sorted.firstKey();
            decreaseCount(startNumber, sorted);

            for (int i = 1; i < k; i++) {
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
