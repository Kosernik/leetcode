package MonthlyChallenges.December21;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumAbsoluteDifference {

    /**
     * LeetCode #1200. Minimum Absolute Difference.
     *
     * Complexity - O(NlogN + N)
     * Memory - O(N)
     *
     * @param arr - an array of integers.
     * @return - a list of pairs of elements with the minimum absolute difference of any two elements. The pairs are in
     *              ascending order.
     */
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(arr);
        int diff = Integer.MAX_VALUE;

        for (int i = 1; i < arr.length; i++) {
            int curDiff = Math.abs(arr[i] - arr[i-1]);

            if (curDiff < diff) {
                diff = curDiff;
                result.clear();

                List<Integer> curPair = new ArrayList<>();
                curPair.add(arr[i-1]);
                curPair.add(arr[i]);
                result.add(curPair);
            } else if (curDiff == diff) {
                List<Integer> curPair = new ArrayList<>();
                curPair.add(arr[i-1]);
                curPair.add(arr[i]);
                result.add(curPair);
            }
        }

        return result;
    }
}
