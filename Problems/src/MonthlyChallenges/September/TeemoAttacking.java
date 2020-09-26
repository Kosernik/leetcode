package MonthlyChallenges.September;

import java.util.Arrays;

public class TeemoAttacking {
    public static void main(String[] args) {
        TeemoAttacking solution = new TeemoAttacking();
        solution.testFindPoisonedDuration();
    }

    /**
     * Returns poisoning duration.
     *
     * Complexity = O(N)
     * Memory - O(1)
     *
     * @param timeSeries - an array of non negative integers, sorted in ascending order, representing the time of an
     *                   attack.
     * @param duration - duration of a poison.
     * @return - total time of poisoning.
     */
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int totalDuration = 0;
        if (timeSeries == null || timeSeries.length == 0 || duration == 0) return totalDuration;

        int stopTime = 0;
        int startTime = 0;

        for (int time : timeSeries) {
            if (time > stopTime) {
                totalDuration += (stopTime - startTime);
                startTime = time;
            }
            stopTime = time + duration;
        }

        totalDuration += (stopTime - startTime);

        return totalDuration;
    }

    private void testFindPoisonedDuration() {
        int[][] testTimeSeries = {
                {1,4},
                {1,2},
                {1,2,3,7,16,20,22,25,27,30,31,39,75},
                {1,2,3,7,16,20,22,25,27,30,31,39,75},
                {1,2,3,7,16,20,22,25,27,30,31,39,75},
                {1,2,3,7,16,20,22,25,27,30,31,39,75},
                {1,2,3,7,16,20,22,25,27,30,31,39,75}
        };
        int[] testDurations = {
                2,
                2,
                1,
                2,
                3,
                4,
                10
        };
        int[] testResults = {
                4,
                3,
                13,
                23,
                31,
                37,
                58
        };

        int failed = 0;

        for (int i = 0; i < testResults.length; i++) {
            if (findPoisonedDuration(testTimeSeries[i], testDurations[i]) != testResults[i]) {
                failed++;
                System.out.println("Failed test: " + Arrays.toString(testTimeSeries[i]) + ", duration: "
                        + testDurations[i]);
                System.out.println("Got: " + findPoisonedDuration(testTimeSeries[i], testDurations[i])
                        + ", instead of: " + testResults[i]);
            }
        }

        System.out.println("Success rate: " + (testResults.length - failed) * 100.0 / testResults.length);
    }
}
