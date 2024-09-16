package MonthlyChallenges.Year24.September;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MinimumTimeDifference {

    /**
     * LeetCode №539. Minimum Time Difference.
     * <p>
     * Complexity - O(NlogN)
     * Memory - O(N)
     *
     * @param timePoints - an array of strings. timePoints[i] - represents the time in the format "HH:MM".
     * @return - the minimum minutes difference between any two time-points in the list.
     */
    public int findMinDifference(List<String> timePoints) {
        List<Integer> times = new ArrayList<>();
        for (String time : timePoints) {    //  "12:34"
            int curTime =
                    ((time.charAt(0) - '0') * 10 + (time.charAt(1) - '0')) * 60 +
                            ((time.charAt(3) - '0') * 10 + (time.charAt(4) - '0'));
            times.add(curTime);
        }

        Collections.sort(times);

        int prev = times.get(0);
        int minDiff = (prev - times.get(times.size() - 1) + 1440) % 1440;

        for (int i = 1; i < times.size(); i++) {
            int cur = times.get(i);
            minDiff = Math.min(minDiff, cur - prev);
            prev = cur;
        }

        return minDiff;
    }
}
