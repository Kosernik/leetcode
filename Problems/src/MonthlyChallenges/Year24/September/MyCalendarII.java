package MonthlyChallenges.Year24.September;

import java.util.ArrayList;
import java.util.List;

public class MyCalendarII {
    /**
     * LeetCode №731. My Calendar II.
     */
    class MyCalendarTwo {
        List<int[]> intervals;
        List<int[]> overlappingIntervals;

        public MyCalendarTwo() {
            intervals = new ArrayList<>();
            overlappingIntervals = new ArrayList<>();
        }

        public boolean book(int start, int end) {
            for (int[] interval : overlappingIntervals) {
                if (isOverlapping(interval, start, end)) {
                    return false;
                }
            }

            for (int[] interval : intervals) {
                if (isOverlapping(interval, start, end)) {
                    overlappingIntervals.add(new int[]{Math.max(interval[0], start), Math.min(interval[1], end)});
                }
            }

            intervals.add(new int[]{start, end});
            return true;
        }

        private boolean isOverlapping(int[] interval, int start, int end) {
            return Math.max(interval[0], start) < Math.min(interval[1], end);
        }
    }

    /**
     * Your MyCalendarTwo object will be instantiated and called as such:
     * MyCalendarTwo obj = new MyCalendarTwo();
     * boolean param_1 = obj.book(start,end);
     */
}
