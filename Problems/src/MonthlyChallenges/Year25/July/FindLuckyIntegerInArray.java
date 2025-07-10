package MonthlyChallenges.Year25.July;

import java.util.HashMap;
import java.util.Map;

public class FindLuckyIntegerInArray {

    /**
     * LeetCode №1394. Find Lucky Integer in an Array.
     * <p>
     * Complexity - O(N)
     * Memory - O(N)
     *
     * @param arr - an array of integers.
     * @return - the largest lucky number or -1 if no lucky number exist.
     */
    public int findLucky(int[] arr) {
        Map<Integer, Integer> counts = new HashMap<>();
        for (int number : arr) {
            counts.put(number, counts.getOrDefault(number, 0) + 1);
        }

        int result = -1;
        for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
            if (entry.getKey().intValue() == entry.getValue().intValue()) {
                result = Math.max(result, entry.getKey());
            }
        }

        return result;
    }
}
