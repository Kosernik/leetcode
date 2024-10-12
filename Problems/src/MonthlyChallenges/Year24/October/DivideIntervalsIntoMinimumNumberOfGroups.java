package MonthlyChallenges.Year24.October;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class DivideIntervalsIntoMinimumNumberOfGroups {

    /**
     * LeetCode №2406. Divide Intervals Into Minimum Number of Groups.
     * <p>
     * Complexity - O(NlogN)
     * Memory - O(N)
     *
     * @param intervals - a 2d array of inclusive intervals.
     * @return - the minimum number of groups of intervals. Each interval is in exactly one group, and no two intervals
     * that are in the same group intersect each other.
     */
    public int minGroups(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        PriorityQueue<Integer> endIntervals = new PriorityQueue<>();

        for (int[] interval : intervals) {
            int start = interval[0];
            int end = interval[1];

            if (!endIntervals.isEmpty() && endIntervals.peek() < start) {
                endIntervals.poll();
            }

            endIntervals.offer(end);
        }

        return endIntervals.size();
    }
}
