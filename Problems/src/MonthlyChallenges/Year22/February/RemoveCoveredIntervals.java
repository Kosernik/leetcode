package MonthlyChallenges.Year22.February;

import java.util.Arrays;

public class RemoveCoveredIntervals {
    public static void main(String[] args) {
        RemoveCoveredIntervals solution = new RemoveCoveredIntervals();

        int[][] test0 = {
                {1,4},{3,6},{2,8},{3,5},{2,4},{2,5}};

        System.out.println(solution.removeCoveredIntervals(test0));
    }

    /**
     * LeetCode #1288. Remove Covered Intervals.
     *
     * Complexity - O(NLogN)
     * Memory - O(1)
     *
     * @param intervals - an array of unique intervals.
     * @return - the number of remaining intervals after removing all intervals that are covered by another interval.
     */
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] == b[0] ? Integer.compare(b[1], a[1]) : Integer.compare(a[0], b[0]));

        int removed = 0;
        int  prevInterval = 0;

        for (int i = 1; i < intervals.length; i++) {
            int[] curInterval = intervals[i];
            if (intervals[prevInterval][0] <= curInterval[0] &&  intervals[prevInterval][1] >= curInterval[1]) {
                removed++;
            } else {
                prevInterval = i;
            }
        }

        return intervals.length - removed;
    }
}
