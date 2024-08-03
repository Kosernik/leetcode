package MonthlyChallenges.Year24.August;

import java.util.HashMap;
import java.util.Map;

public class MakeTwoArraysEqualByReversingSubarrays {

    /**
     * LeetCode №1460. Make Two Arrays Equal by Reversing Subarrays.
     * <p>
     * Complexity - O(N)
     * Memory - O(N)
     * <p>
     * Reverse operation - reverse any non-empty subarray of arr.
     *
     * @param target - an array of integers.
     * @param arr    - an array of integers. target.length = arr.length.
     * @return - true - if it is possible to make arr equal to target by performing any number of reverse operations,
     * false - otherwise.
     */
    public boolean canBeEqual(int[] target, int[] arr) {
        Map<Integer, Integer> counts = new HashMap<>();

        for (int i = 0; i < target.length; i++) {
            counts.put(target[i], counts.getOrDefault(target[i], 0) + 1);
            counts.put(arr[i], counts.getOrDefault(arr[i], 0) - 1);
        }

        for (int val : counts.values()) {
            if (val != 0) return false;
        }
        return true;
    }
}
