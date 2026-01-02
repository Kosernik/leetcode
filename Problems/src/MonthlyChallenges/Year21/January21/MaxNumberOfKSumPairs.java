package MonthlyChallenges.Year21.January21;

import java.util.HashMap;
import java.util.Map;

public class MaxNumberOfKSumPairs {
    /**
     * LeetCode #1679.
     * <p>
     * Returns the number of operations of removing pairs of numbers whose sum equals "k".
     * <p>
     * Complexity - O(N)
     * Memory - O(N)
     *
     * @param nums - array of integers. Not null.
     * @param k    - positive integer.
     * @return - maximum number of operations.
     */
    public int maxOperations(int[] nums, int k) {
        Map<Integer, Integer> counts = new HashMap<>();

        for (int number : nums) {
            if (!counts.containsKey(number)) {
                counts.put(number, 0);
            }
            counts.put(number, counts.get(number) + 1);
        }

        int operations = 0;

        for (int number : nums) {
            if (counts.get(number) > 0) {
                int diff = k - number;
                if (diff == number) {
                    if (counts.get(number) > 1) {
                        operations++;
                        counts.put(number, counts.get(number) - 2);
                    }
                } else if (counts.containsKey(diff) && counts.get(diff) > 0) {
                    operations++;
                    counts.put(number, counts.get(number) - 1);
                    counts.put(diff, counts.get(diff) - 1);
                }
            }
        }

        return operations;
    }
}
