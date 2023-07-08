package MonthlyChallenges.Year23.July;

import java.util.Arrays;

public class PutMarblesInBags {

    /**
     * LeetCode #2551. Put Marbles in Bags.
     *
     * @param weights - an array of weight of each marble.
     * @param k       - the total number of bags.
     * @return - the difference between max and min scores.
     */
    public long putMarbles(int[] weights, int k) {
        int length = weights.length - 1;
        int[] pairSums = new int[length];
        for (int i = 0; i < length; i++) {
            pairSums[i] = weights[i] + weights[i + 1];
        }
        Arrays.sort(pairSums);

        long score = 0L;

        for (int i = 0; i < k - 1; i++) {
            score += pairSums[length - i - 1] - pairSums[i];
        }

        return score;
    }
}
