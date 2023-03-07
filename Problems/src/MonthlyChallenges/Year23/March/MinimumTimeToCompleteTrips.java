package MonthlyChallenges.Year23.March;

import java.util.Arrays;

public class MinimumTimeToCompleteTrips {

    /**
     * LeetCode #2187. Minimum Time to Complete Trips.
     * <p>
     * Complexity - O(NlogN)
     * Memory - O(1)
     *
     * @param time       - an array of positive integers.
     * @param totalTrips - a positive integer.
     * @return - the minimum time required for all buses to complete at least 'totalTrips' trips.
     */
    public long minimumTime(int[] time, int totalTrips) {
        Arrays.sort(time);

        long left = time[0];
        long right = left * (long) totalTrips;
        long middle;

        while (left < right) {
            middle = (right - left) / 2L + left;

            if (canFinishInTime(time, middle, totalTrips)) {
                right = middle;
            } else {
                left = middle + 1;
            }
        }

        return left;
    }

    private boolean canFinishInTime(int[] time, long candidateTime, int totalTrips) {
        int finished = 0;
        for (int curTime : time) {
            if (curTime > candidateTime) break;

            int curNumberOfTrips = (int) (candidateTime / curTime);
            finished += curNumberOfTrips;
            if (finished >= totalTrips) {
                return true;
            }
        }
        return false;
    }
}
