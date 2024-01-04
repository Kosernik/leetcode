package MonthlyChallenges.Year24.January;

import java.util.HashMap;
import java.util.Map;

public class MinimumNumberOfOperationsToMakeArrayEmpty {

    /**
     * LeetCode №2870. Minimum Number of Operations to Make Array Empty.
     * <p>
     * Complexity - O(N)
     * Memory - O(N)
     *
     * @param nums - an array of integers.
     * @return - the minimum number of operations required to make the array empty, or -1 if it is not possible.
     */
    public int minOperations(int[] nums) {
        Map<Integer, Integer> counts = new HashMap<>();
        for (int number : nums) {
            counts.put(number, counts.getOrDefault(number, 0) + 1);
        }

        int numberOfOperations = 0;

        for (int count : counts.values()) {
            if (count == 1) return -1;

            numberOfOperations += count / 3 + (count % 3 == 0 ? 0 : 1);
        }

        return numberOfOperations;
    }
}
