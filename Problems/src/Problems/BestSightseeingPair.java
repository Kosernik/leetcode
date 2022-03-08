package Problems;

public class BestSightseeingPair {

    /**
     * LeetCode #1014. Best Sightseeing Pair.
     *
     * Complexity - O(N)
     * Memory - O(1)
     *
     * @param values - an array of positive integers.
     * @return - the maximum score of a pair of sightseeing spots.
     *           The score of a pair (i < j) of sightseeing spots is values[i] + values[j] + i - j.
     */
    public int maxScoreSightseeingPair(int[] values) {
        int result = 0;

        int prev = values[0];

        for (int i = 1; i < values.length; i++) {
            result = Math.max(result, prev + values[i] - i);
            prev = Math.max(prev, values[i] + i);
        }

        return result;
    }
}
