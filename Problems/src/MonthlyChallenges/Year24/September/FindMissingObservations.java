package MonthlyChallenges.Year24.September;

import java.util.Arrays;

public class FindMissingObservations {

    /**
     * LeetCode №2028. Find Missing Observations.
     * <p>
     * Complexity - O(M + N), M = rolls.length, N = n
     * Memory - O(1)
     *
     * @param rolls - an array of known dice rolls.
     * @param mean  - the average value of all M+N rolls. The sum of M+N rolls is divisible by M+N.
     * @param n     - the number of missing rolls.
     * @return - an array of any valid rolls such that the average value of the M+N rolls is exactly mean.
     */
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int givenSum = 0;
        for (int roll : rolls) givenSum += roll;

        int totalSum = (rolls.length + n) * mean;

        int missingSum = totalSum - givenSum;

        if (missingSum < n || missingSum > (n * 6)) return new int[0];

        int missingMean = missingSum / n;

        int[] result = new int[n];
        Arrays.fill(result, missingMean);

        int curSum = missingMean * n;
        int idx = 0;

        while (curSum < missingSum) {
            int curDiff = missingSum - curSum;

            int delta = Math.min(curDiff, 6 - missingMean);

            result[idx] += delta;
            curSum += delta;
            idx++;
        }

        return result;
    }
}
