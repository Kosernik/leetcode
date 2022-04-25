package Problems;

import java.util.NavigableSet;
import java.util.TreeSet;

public class MinimumAbsoluteSumDifference {

    /**
     * LeetCode #1818. Minimum Absolute Sum Difference.
     *
     * Complexity - O(N*logN)
     * Memory - O(N)
     *
     * @param nums1 - an array of positive integers.
     * @param nums2 - an array of positive integers.
     * @return - the minimum absolute sum difference after replacing at most one element in the array nums1.
     */
    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        int MODULO = 1_000_000_007;

        int length = nums1.length;
        int[] diffs = new int[length];

        int bestSwap = 0;
        int bestSwapIdx = -1;
        NavigableSet<Integer> numbers = new TreeSet<>();

        for (int i = 0; i < length; i++) {
            diffs[i] = Math.abs(nums1[i] - nums2[i]);
            numbers.add(nums1[i]);
        }

        for (int i = 0; i < length; i++) {
            if (diffs[i] == 0) continue;

            int target = nums2[i];
            Integer smallest = numbers.floor(target);
            Integer highest = numbers.ceiling(target);

            int curSwap = diffs[i];
            if (smallest != null) {
                int cur = Math.abs(smallest - target);
                curSwap = Math.min(curSwap, cur);
            }
            if (highest != null) {
                int cur = Math.abs(highest - target);
                curSwap = Math.min(curSwap, cur);
            }

            if (curSwap < diffs[i]) {
                int curWin = diffs[i] - curSwap;
                if (bestSwap < curWin) {
                    bestSwap = curWin;
                    bestSwapIdx = i;
                }
            }
        }

        if (bestSwapIdx == -1) return 0;
        diffs[bestSwapIdx] = diffs[bestSwapIdx] - bestSwap;
        int result = 0;
        for (int diff : diffs) {
            result += diff;
            result %= MODULO;
        }
        return result;
    }
}
