package MonthlyChallenges.Year22.September;

import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

public class FindOriginalArrayFromDoubledArray {

    /**
     * LeetCode #2007. Find Original Array From Doubled Array.
     * <p>
     * Complexity - O(NlogN)
     * Memory - O(N)
     *
     * @param changed - an array of integers.
     * @return - original array - if changed is a doubled array, empty array - otherwise.
     */
    public int[] findOriginalArray(int[] changed) {
        if (changed.length % 2 == 1) return new int[]{};
        int[] result = new int[changed.length / 2];
        int idx = 0;

        NavigableMap<Integer, Integer> counts = new TreeMap<>();
        for (int val : changed) {
            counts.put(val, counts.getOrDefault(val, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
            if (entry.getValue() == 0) continue;

            int val = entry.getKey();
            if (!counts.containsKey(val * 2) || counts.get(val * 2) < entry.getValue()) {
                return new int[]{};
            } else {
                counts.put(val * 2, counts.get(val * 2) - entry.getValue());
            }

            for (int i = 0; i < entry.getValue(); i++) {
                result[idx++] = val;
            }
        }

        return result;
    }
}
