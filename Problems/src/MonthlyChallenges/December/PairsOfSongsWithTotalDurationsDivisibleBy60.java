package MonthlyChallenges.December;

public class PairsOfSongsWithTotalDurationsDivisibleBy60 {

    /**
     * LeetCode #1010.
     *
     * Complexity - O(N)
     * Memory - O(1)
     *
     * @param time - array of durations of songs.
     * @return - the number of pairs of songs for which their total duration in seconds is divisible by 60.
     */
    public int numPairsDivisibleBy60(int[] time) {
        if (time == null || time.length == 0) return 0;

        int[] counts = new int[60];

        for (int t : time) {
            counts[t%60]++;
        }

        int numberOfPairs = counts[0] <= 1 ? 0 : ((counts[0] - 1) * counts[0]) / 2;
        numberOfPairs += counts[30] <= 1 ? 0 : ((counts[30] - 1) * counts[30]) / 2;

        for (int i = 1; i < 30; i++) {
            numberOfPairs += counts[i] * counts[60 - i];
        }

        return numberOfPairs;
    }
}
