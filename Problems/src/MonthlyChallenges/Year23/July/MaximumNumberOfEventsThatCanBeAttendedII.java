package MonthlyChallenges.Year23.July;

import java.util.Arrays;

public class MaximumNumberOfEventsThatCanBeAttendedII {

    /**
     * LeetCode #1751. Maximum Number of Events That Can Be Attended II.
     * <p>
     * Complexity - O(N*K*logN), N = events.length
     * Memory - O(N*k)
     *
     * @param events - an array of events. events[i] = {startTime, endTime, value}
     * @param k      - the maximum number of events.
     * @return - the maximum sum of values that you can receive by attending events.
     */

    public int maxValue(int[][] events, int k) {
        Arrays.sort(events, (a, b) -> Integer.compare(a[0], b[0]));

        int[][] computed = new int[k + 1][events.length];
        for (int[] row : computed) {
            Arrays.fill(row, -1);
        }

        return helper(0, events, k, computed);
    }

    private int helper(int idx, int[][] events, int k, int[][] computed) {
        if (idx >= events.length || k <= 0) {
            return 0;
        } else if (computed[k][idx] != -1) {
            return computed[k][idx];
        }

        int ignoreCurrent = helper(idx + 1, events, k, computed);

        int idxNext = binSearch(events, idx);
        int pickCurrent = events[idx][2] + helper(idxNext, events, k - 1, computed);

        computed[k][idx] = Math.max(ignoreCurrent, pickCurrent);
        return computed[k][idx];
    }

    private int binSearch(int[][] events, int startIdx) {
        int target = events[startIdx][1];

        int left = startIdx + 1;
        int right = events.length;
        int middle;

        while (left < right) {
            middle = (right - left) / 2 + left;

            int curStartTime = events[middle][0];
            if (curStartTime <= target) {
                left = middle + 1;
            } else {
                right = middle;
            }
        }
        return left;
    }
}
