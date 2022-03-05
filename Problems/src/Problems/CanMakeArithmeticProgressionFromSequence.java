package Problems;

import java.util.Arrays;

public class CanMakeArithmeticProgressionFromSequence {

    /**
     * LeetCode #1502. Can Make Arithmetic Progression From Sequence.
     *
     * Complexity - O(NlogN)
     * Memory - O(1)
     *
     * @param arr - an array of integers.
     * @return - True - if the array can be rearranged to form an arithmetic progression. False - otherwise.
     */
    public boolean canMakeArithmeticProgression(int[] arr) {
        Arrays.sort(arr);
        int diff = arr[1] - arr[0];

        for (int i = 2; i < arr.length; i++) {
            if (arr[i] - arr[i-1] != diff) return false;
        }

        return true;
    }
}
