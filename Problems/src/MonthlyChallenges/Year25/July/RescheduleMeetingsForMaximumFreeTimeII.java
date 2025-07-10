package MonthlyChallenges.Year25.July;

public class RescheduleMeetingsForMaximumFreeTimeII {

    /**
     * LeetCode №3440. Reschedule Meetings for Maximum Free Time II.
     * <p>
     * Complexity - O(N), N = startTime.length = endTime.length
     * Memory - O(1)
     *
     * @param eventTime - the end time of an event.
     * @param startTime - a sorted array of start times of meetings
     * @param endTime   - a sorted array of end times of meetings.
     * @return - the maximum amount of free time possible after rearranging the meetings.
     */
    public int maxFreeTime(int eventTime, int[] startTime, int[] endTime) {
        int result = 0;

        int longestPrevPause = 0;

        int prevEnd = 0;
        for (int i = 0; i < startTime.length; i++) {
            int curStart = startTime[i];
            int curEnd = endTime[i];

            int leftPause = curStart - prevEnd;

            int rightEnd = (i + 1 < startTime.length) ? startTime[i + 1] : eventTime;
            int rightPause = rightEnd - curEnd;

            int curLength = curEnd - curStart;

            if (curLength <= longestPrevPause) {
                result = Math.max(result, leftPause + rightPause + curLength);
            }

            // Slide current interval
            result = Math.max(result, leftPause + rightPause);

            longestPrevPause = Math.max(longestPrevPause, leftPause);
            prevEnd = curEnd;
        }

        longestPrevPause = 0;

        int prevStart = eventTime;
        for (int i = startTime.length - 1; i >= 0; i--) {
            int curStart = startTime[i];
            int curEnd = endTime[i];

            int rightPause = prevStart - curEnd;

            int leftEnd = (i - 1 >= 0) ? endTime[i - 1] : 0;
            int leftPause = curStart - leftEnd;

            int curLength = curEnd - curStart;

            if (curLength <= longestPrevPause) {
                result = Math.max(result, leftPause + curLength + rightPause);
            }

            longestPrevPause = Math.max(longestPrevPause, rightPause);
            prevStart = curStart;
        }

        return result;
    }
}
