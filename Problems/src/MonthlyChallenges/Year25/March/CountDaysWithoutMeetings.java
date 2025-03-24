package MonthlyChallenges.Year25.March;

import java.util.Arrays;
import java.util.Comparator;

public class CountDaysWithoutMeetings {

    /**
     * LeetCode №3169. Count Days Without Meetings.
     * <p>
     * Complexity - O(NlogN)
     * Memory - O(1)
     *
     * @param days     - the total number of days.
     * @param meetings - an array of intervals, where meetings[i][0] is the starting day and meeting[i][1] is the ending
     *                 day (inclusive) of a meeting.
     * @return - the number of days without a meeting.
     */
    public int countDays(int days, int[][] meetings) {
        int freeDays = 0;

        Arrays.sort(meetings, Comparator.comparingInt(a -> a[0]));

        int prev = 0;

        for (int[] meeting : meetings) {
            int start = meeting[0];
            int end = meeting[1];

            int diff = Math.max(start, prev) - prev;

            if (diff > 0) {
                freeDays += diff - 1;
            }

            prev = Math.max(prev, end);
        }

        if (days - prev > 0) {
            freeDays += days - prev;
        }

        return freeDays;
    }
}
