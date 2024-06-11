package MonthlyChallenges.Year24.June;

import java.util.*;

public class RelativeSortArray {

    /**
     * LeetCode №1122. Relative Sort Array.
     * <p>
     * Complexity - O(M + N + NlogN), N = arr1.length, M = arr2.length
     * Memory - O(N+M)
     *
     * @param arr1 - an array of integers.
     * @param arr2 - an array of distinct integers.
     * @return - relatively sorted array arr1.
     */
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> indices = new HashMap<>();
        for (int i = 0; i < arr2.length; i++) {
            indices.put(arr2[i], i);
        }

        int[] relativelySorted = new int[arr1.length];

        List<Integer> relTemp = new ArrayList<>();
        List<Integer> normalTemp = new ArrayList<>();

        for (int number : arr1) {
            if (!indices.containsKey(number)) {
                normalTemp.add(number);
            } else {
                relTemp.add(number);
            }
        }

        relTemp.sort(Comparator.comparingInt(indices::get));
        normalTemp.sort(Comparator.comparingInt(a -> a));

        for (int i = 0; i < relTemp.size(); i++) {
            relativelySorted[i] = relTemp.get(i);
        }
        for (int i = relTemp.size(), j = 0; j < normalTemp.size(); i++, j++) {
            relativelySorted[i] = normalTemp.get(j);
        }

        return relativelySorted;
    }
}
