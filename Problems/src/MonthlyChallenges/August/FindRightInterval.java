package MonthlyChallenges.August;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class FindRightInterval {

    /**
     * Building an array of indexes of "right" intervals. Interval 'j' is "on the right" of 'i' if it`s start point is
     * bigger or equal to the end point of 'i'-th interval. If there are no "right" interval, then "-1" is the result
     * for this interval.
     *
     * Complexity - O(N*LogN)
     * Memory - O(N)
     *
     * @param intervals - array of integer intervals,
     *      *                  intervals[i][0] < intervals[i][1],
     *      *                  intervals[i][0] != intervals[j][0].
     * @return array of indexes of "right" intervals or empty array if no intervals provided.
     */
    public int[] findRightIntervalAlt(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return new int[] {};

        int[] result = new int[intervals.length];
        if (intervals.length == 1) {
            result[0] = -1;
            return result;
        }

        // Building a tree map of entries <start point, index of an interval>
        TreeMap<Integer, Integer> indexes = new TreeMap<>();
        for (int i = 0; i < intervals.length; i++) {
            // Key - start point, Value - index of an interval>
            indexes.put(intervals[i][0], i);
        }

        // Iterating over an array of intervals and finding start point, that is bigger or equal to end point of
        // current interval. If there is no such point, appending "-1" as an answer for current interval.
        for (int i = 0; i < intervals.length; i++) {
            int rightInterval = intervals[i][1];
            Integer biggerOrEqualValue = indexes.ceilingKey(rightInterval);
            if (biggerOrEqualValue != null) {
                result[i] = indexes.get(biggerOrEqualValue);
            } else {
                result[i] = -1;
            }
        }

        return result;
    }

    public int[] findRightInterval(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return new int[] {};

        int[] result = new int[intervals.length];
        if (intervals.length == 1) {
            result[0] = -1;
            return result;
        }

        TreeMap<Integer, List<Integer>> indexes = new TreeMap<>();
        for (int i = 0; i < intervals.length; i++) {
            int leftInterval = intervals[i][0];
            if (!indexes.containsKey(leftInterval)) {
                indexes.put(leftInterval, new ArrayList<>());
            }
            List<Integer> currList = indexes.get(leftInterval);
            currList.add(i);
        }

        for (int i = 0; i < intervals.length; i++) {
            int rightInterval = intervals[i][1];
            Integer biggerOrEqualValue = indexes.ceilingKey(rightInterval);
            if (biggerOrEqualValue != null) {
                List<Integer> currList = indexes.get(biggerOrEqualValue);

                int index = currList.get(0);
                if (index != i) {
                    result[i] = index;
                } else {
                    if (currList.size() > 1) {
                        result[i] = currList.get(1);
                    } else {
                        Integer biggerValue = indexes.ceilingKey(rightInterval+1);
                        if (biggerValue != null) {
                            List<Integer> altList = indexes.get(biggerValue);
                            result[i] = altList.get(0);
                        } else {
                            result[i] = -1;
                        }
                    }
                }
            } else {
                result[i] = -1;
            }
        }

        return result;
    }
}
