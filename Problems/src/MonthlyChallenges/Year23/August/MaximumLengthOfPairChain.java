package MonthlyChallenges.Year23.August;

import java.util.Arrays;

public class MaximumLengthOfPairChain {

    /**
     * LeetCode #646. Maximum Length of Pair Chain.
     * <p>
     * Complexity - O(NlogN)
     * Memory - O(1)
     *
     * @param pairs - a 2d-array of intervals. pairs[i][0] < pairs[i][1].
     * @return - the length of the longest chain of intervals.
     */
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a, b) -> a[0] != b[0] ? Integer.compare(a[0], b[0]) : Integer.compare(a[1], b[1]));

        int maxLength = 1;
        int prevIntervalEnd = pairs[0][1];

        for (int i = 1; i < pairs.length; i++) {
            int[] currentInterval = pairs[i];

            if (currentInterval[0] > prevIntervalEnd) {
                maxLength++;
                prevIntervalEnd = currentInterval[1];
            } else if (currentInterval[1] < prevIntervalEnd) {
                prevIntervalEnd = currentInterval[1];
            }
        }

        return maxLength;
    }
}
