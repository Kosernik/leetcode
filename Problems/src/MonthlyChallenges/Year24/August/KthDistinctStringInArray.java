package MonthlyChallenges.Year24.August;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class KthDistinctStringInArray {

    /**
     * LeetCode №2053. Kth Distinct String in an Array.
     * <p>
     * Complexity - O(N + NlogK), N = arr.length, K = k.
     * Memory - O(N+K)
     *
     * @param arr - an array of strings.
     * @param k   - the number of a distinct string.
     * @return - k-th distinct string. If there are fewer than k distinct strings, returns an empty string "".
     */
    public String kthDistinct(String[] arr, int k) {
        Map<String, int[]> uniques = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            int[] uniquenessAndIdx = new int[]{0, i};
            if (uniques.containsKey(arr[i])) {
                uniquenessAndIdx[0] = 1;
            }
            uniques.put(arr[i], uniquenessAndIdx);
        }

        PriorityQueue<Integer> indices = new PriorityQueue<>(Comparator.reverseOrder());
        for (int[] value : uniques.values()) {
            if (value[0] == 0) {
                indices.offer(value[1]);
                if (indices.size() > k) indices.poll();
            }
        }

        if (indices.size() == k) {
            return arr[indices.poll()];
        } else {
            return "";
        }
    }
}
