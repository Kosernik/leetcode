package MonthlyChallenges.September;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class InsertInterval {
    public static void main(String[] args) {
        InsertInterval solution = new InsertInterval();

//        int[][] test2 = {{1,2},{5,6},{10,11}};
//        int[] inter2 = {4,8};
//        int[][] res2 = solution.insert(test2, inter2);
//        for (int[] i : res2) System.out.print(Arrays.toString(i));
//        System.out.println();

//        int[][] test3 = {{2,4},{5,6},{7,10}};
//        int[] inter3 = {1,11};
//        int[][] res3 = solution.insert(test3, inter3);
//        for (int[] i : res3) System.out.print(Arrays.toString(i));
//        System.out.println();

        int[][] test4 = {{3,5},{12,15}};
        int[] inter4 = {6,6};
        int[][] res4 = solution.insert(test4, inter4);
        for (int[] i : res4) System.out.print(Arrays.toString(i));
        System.out.println();
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals == null || intervals.length == 0) {
            int[][] r = new int[1][];
            r[0] = newInterval;
            return r;
        }
        else if (newInterval == null || newInterval.length == 0) return intervals;

        if (newInterval[1] < intervals[0][0]) {
            int[][] r = new int[intervals.length+1][];
            r[0] = newInterval;
            System.arraycopy(intervals, 0, r, 1, intervals.length);
            return r;
        } else if (newInterval[0] > intervals[intervals.length-1][1]) {
            int[][] r = new int[intervals.length+1][];
            System.arraycopy(intervals, 0, r, 0, intervals.length);
            r[intervals.length] = newInterval;
            return r;
        }

        List<int[]> result = new ArrayList<>();

        int[] merged = new int[2];
        int i = 0;
        for (; i < intervals.length; i++) {
            if (intervals[i][1] >= newInterval[0]) {
                merged[0] = Math.min(intervals[i][0], newInterval[0]);
                if (newInterval[1] < intervals[i][0]) {
                    merged[1] = newInterval[1];
                } else {
                    merged[1] = Math.max(intervals[i][1], newInterval[1]);
                    i++;
                }
                break;
            } else {
                result.add(intervals[i]);
            }
        }

        while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
            merged[1] = Math.max(intervals[i][1], newInterval[1]);
            i++;
        }

        result.add(merged);

        for (; i < intervals.length; i++) {
            result.add(intervals[i]);
        }

        int[][] inserted = new int[result.size()][2];
        i = 0;
        for (int[] interval : result) {
            inserted[i++] = interval;
        }
        return inserted;
    }
}
