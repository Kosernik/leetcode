package MonthlyChallenges.Year25.February;

import java.util.HashMap;
import java.util.Map;

public class FindNumberOfDistinctColorsAmongBalls {

    /**
     * LeetCode №3160. Find the Number of Distinct Colors Among the Balls.
     * <p>
     * Complexity - O(M), N = limit+1, M = queries.length.
     * Memory - O(N + M)
     *
     * @param limit   - the index of a last ball, the total number of balls is limit + 1.
     * @param queries - 2d array of queries, query[i][0] - an index of a ball, query[i][1] - the new colour of a ball.
     *                query[i][1] is a positive integer.
     * @return - an array of answers for each query, result[i] denotes the number of distinct colors after i-th query.
     */
    public int[] queryResults(int limit, int[][] queries) {
        Map<Integer, Integer> ballsColours = new HashMap<>();
        Map<Integer, Integer> coloursCounts = new HashMap<>();

        int[] result = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            int ball = query[0];
            int colour = query[1];

            int ballOldColour = ballsColours.getOrDefault(ball, 0);

            if (ballOldColour == colour) {
                result[i] = coloursCounts.size();
                continue;
            } else if (ballOldColour != 0) {
                int oldColourCount = coloursCounts.get(ballOldColour);
                oldColourCount--;

                if (oldColourCount == 0) {
                    coloursCounts.remove(ballOldColour);
                } else {
                    coloursCounts.put(ballOldColour, oldColourCount);
                }
            }

            coloursCounts.put(colour, coloursCounts.getOrDefault(colour, 0) + 1);
            ballsColours.put(ball, colour);

            result[i] = coloursCounts.size();
        }

        return result;
    }
}
