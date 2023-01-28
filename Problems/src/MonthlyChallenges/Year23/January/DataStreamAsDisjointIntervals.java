package MonthlyChallenges.Year23.January;

import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

public class DataStreamAsDisjointIntervals {

    /**
     * LeetCode #352. Data Stream as Disjoint Intervals.
     * <p>
     * Complexity - O(NlogN)
     * Memory - O(N)
     */
    class SummaryRanges {
        private final NavigableMap<Integer, Integer> ranges;

        public SummaryRanges() {
            this.ranges = new TreeMap<>();
        }

        public void addNum(int value) {
            if (this.ranges.isEmpty()) {
                this.ranges.put(value, value);
                return;
            }

            Integer prevStart = this.ranges.floorKey(value);
            Integer nextStart = this.ranges.ceilingKey(value);

            if (prevStart == null) {
                if (value + 1 < nextStart) {
                    this.ranges.put(value, value);
                } else {
                    int end = this.ranges.get(nextStart);
                    this.ranges.remove(nextStart);
                    this.ranges.put(value, end);
                }
            } else if (nextStart == null) {
                int end = this.ranges.get(prevStart);
                if (end + 1 < value) {
                    this.ranges.put(value, value);
                } else if (end + 1 == value) {
                    this.ranges.put(prevStart, value);
                }
            } else {
                int prevEnd = this.ranges.get(prevStart);
                int nextEnd = this.ranges.get(nextStart);
                if ((prevStart <= value && value <= prevEnd) || nextStart == value) return;

                if (prevEnd + 1 == value && value == nextStart - 1) {  //  union two intervals
                    this.ranges.put(prevStart, nextEnd);
                    this.ranges.remove(nextStart);
                } else if (prevEnd + 1 < value && value < nextStart - 1) {   //  add new
                    this.ranges.put(value, value);
                } else if (prevEnd + 1 == value && value < nextStart - 1) { //  add to left
                    this.ranges.put(prevStart, value);
                } else if (value + 1 == nextStart) {  //  add to right
                    this.ranges.remove(nextStart);
                    this.ranges.put(value, nextEnd);
                }
            }
        }

        public int[][] getIntervals() {
            int[][] intervals = new int[this.ranges.size()][];
            int idx = 0;

            for (Map.Entry<Integer, Integer> pair : this.ranges.entrySet()) {
                intervals[idx] = new int[]{pair.getKey(), pair.getValue()};
                idx++;
            }

            return intervals;
        }
    }
}
