package MonthlyChallenges.Year24.December;

import java.util.Arrays;

public class TwoBestNonOverlappingEvents {
    public static void main(String[] args) {
        TwoBestNonOverlappingEvents solution = new TwoBestNonOverlappingEvents();

        int[][] test0 = {{1, 3, 2}, {4, 5, 2}, {2, 4, 3}};
        System.out.println(solution.maxTwoEvents(test0) == 4);

        int[][] test1 = {{1, 1, 1}, {1, 1, 1}};
        System.out.println(solution.maxTwoEvents(test1) == 1);
    }

    /**
     * LeetCode №2054. Two Best Non-Overlapping Events.
     * <p>
     * Complexity - O(NlogN)
     * Memory - O(N)
     *
     * @param events - an array of intervals. events[i] = [startTime-i, endTime-i, value-i]
     * @return - the maximum sum of any two non-overlapping events.
     */
    public int maxTwoEvents(int[][] events) {
        Arrays.sort(events, (a, b) -> Integer.compare(a[1], b[1]));

        int[] maxValue = new int[events.length + 1];
        for (int i = 0; i < events.length; i++) {
            maxValue[i + 1] = Math.max(maxValue[i], events[i][2]);
        }

        int result = events[0][2];

        for (int i = 1; i < events.length; i++) {
            int[] event = events[i];

            int prevIdx = binarySearchRightmost(event[0], events);

            int prevVal;
            if (prevIdx == 0) {
                if (event[0] <= events[0][1]) {
                    prevVal = 0;
                } else {
                    prevVal = maxValue[prevIdx + 1];
                }
            } else {
                prevVal = maxValue[prevIdx + 1];
            }

            result = Math.max(result, event[2] + prevVal);
        }

        return result;
    }

    private int binarySearchRightmost(int target, int[][] events) {
        int left = 0, right = events.length - 1, middle;

        while (left < right) {
            middle = right - (right - left) / 2;

            if (events[middle][1] < target) {
                left = middle;
            } else {
                right = middle - 1;
            }
        }

        return left;
    }
}
