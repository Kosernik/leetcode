package MonthlyChallenges.Year23.October;

import java.util.HashMap;
import java.util.Map;

public class NumberOfGoodPairs {

    /**
     * LeetCode #1512. Number of Good Pairs.
     * <p>
     * Complexity - O(N)
     * Memory - O(N)
     *
     * @param nums - an array of integers.
     * @return - the total number of good pairs. A pair is good if nums[i] == nums[j].
     */
    public int numIdenticalPairs(int[] nums) {
        int goodPairs = 0;
        Map<Integer, Integer> counts = new HashMap<>();

        for (int number : nums) {
            if (counts.containsKey(number)) {
                goodPairs += counts.get(number);
            }
            counts.put(number, counts.getOrDefault(number, 0) + 1);
        }

        return goodPairs;
    }
}
