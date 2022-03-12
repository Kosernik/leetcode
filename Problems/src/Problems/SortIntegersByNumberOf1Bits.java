package Problems;

import java.util.ArrayList;
import java.util.List;

public class SortIntegersByNumberOf1Bits {

    /**
     * LeetCode #1356. Sort Integers by The Number of 1 Bits.
     *
     * Complexity - O(NlogN)
     * Memory - O(N)
     *
     * @param arr - an array of integers.
     * @return - arr sorted in ascending order by the number of 1 bits.
     */
    public int[] sortByBits(int[] arr) {
        List<Integer> copied = new ArrayList<>();
        for (int i : arr) copied.add(i);

        copied.sort((a, b) ->
                Integer.bitCount(a) == Integer.bitCount(b) ?
                        Integer.compare(a, b) :
                        Integer.compare(Integer.bitCount(a), Integer.bitCount(b)));

        int[] sorted = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            sorted[i] = copied.get(i);
        }

        return sorted;
    }
}
