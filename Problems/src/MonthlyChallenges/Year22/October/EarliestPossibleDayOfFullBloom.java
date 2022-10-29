package MonthlyChallenges.Year22.October;

import java.util.Arrays;

public class EarliestPossibleDayOfFullBloom {

    /**
     * LeetCode 2136. Earliest Possible Day of Full Bloom.
     * <p>
     * Complexity - O(NlogN)
     * Memory - O(N)
     *
     * @param plantTime - an array of positive integers, plantTime[i] = the number of full days it takes you to plant
     *                  the i-th seed.
     * @param growTime  - an array of positive integers, growTime[i] = the number of full days it takes the ith seed to
     *                  grow after being completely planted.
     * @return - the earliest possible day when all seeds are blooming.
     */
    public int earliestFullBloom(int[] plantTime, int[] growTime) {
        int[][] combinedTimes = new int[plantTime.length][2];

        for (int i = 0; i < combinedTimes.length; i++) {
            combinedTimes[i][0] = plantTime[i];
            combinedTimes[i][1] = growTime[i];
        }

        Arrays.sort(combinedTimes, (a, b) -> a[1] != b[1] ? Integer.compare(b[1], a[1]) : Integer.compare(a[0], b[0]));

        int result = 0;
        int totalPlantTime = 0;

        for (int[] combinedTime : combinedTimes) {
            totalPlantTime += combinedTime[0];
            result = Math.max(result, totalPlantTime + combinedTime[1]);
        }

        return result;
    }
}
