package MonthlyChallenges.Year25.July;

import java.util.ArrayDeque;
import java.util.Deque;

public class RescheduleMeetingsForMaximumFreeTimeI {
    public static void main(String[] args) {
        RescheduleMeetingsForMaximumFreeTimeI solution = new RescheduleMeetingsForMaximumFreeTimeI();

        int eventTime0 = 10;
        int k0 = 1;
        int[] startTime0 = {0, 2, 5, 9};
        int[] endTime = {1, 4, 6, 10};
        int result0 = 4;
        System.out.println(solution.maxFreeTime(eventTime0, k0, startTime0, endTime) == result0);
    }

    /**
     * LeetCode №3439. Reschedule Meetings for Maximum Free Time I.
     * <p>
     * Complexity - O(N) N = startTime.length = endTime.length.
     * Memory - O(K)
     *
     * @param eventTime - the end time of an event.
     * @param k         - the total number of meetings allowed to move.
     * @param startTime - a sorted array of start times of meetings
     * @param endTime   - a sorted array of end times of meetings.
     * @return - the maximum amount of free time possible after rearranging the meetings.
     */
    public int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime) {
        int maxTime = 0;

        int left = 0;
        int movedLength = 0;

        //  {idx, length}
        Deque<int[]> deque = new ArrayDeque<>();

        for (int i = 0; i < startTime.length; i++) {
            int curLength = endTime[i] - startTime[i];
            deque.offerLast(new int[]{i, curLength});

            maxTime = Math.max(maxTime, startTime[i] - left - movedLength);

            if (deque.size() > k) {
                int[] unmove = deque.removeFirst();
                movedLength -= unmove[1];
                left = endTime[unmove[0]];
            }

            movedLength += curLength;
        }

        if (deque.size() > k) {
            int[] unmove = deque.removeFirst();
            movedLength -= unmove[1];
            left = endTime[unmove[0]];
        }
        maxTime = Math.max(maxTime, eventTime - left - movedLength);

        return maxTime;
    }
}
