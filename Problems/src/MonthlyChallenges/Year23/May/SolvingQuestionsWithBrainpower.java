package MonthlyChallenges.Year23.May;

public class SolvingQuestionsWithBrainpower {

    /**
     * LeetCode #2140. Solving Questions With Brainpower.
     * <p>
     * Complexity - O(N)
     * Memory - O(N)
     *
     * @param questions - a 2d array of questions. question[i] = {points, brain power}
     * @return - the maximum points it is possible to earn.
     */
    public long mostPoints(int[][] questions) {
        int length = questions.length;
        long[] dp = new long[length + 1];

        for (int i = length - 1; i >= 0; i--) {
            int[] question = questions[i];
            int idxWithoutConflicts = Math.min(question[1] + i + 1, length);
            long pointsIfAccept = question[0] + dp[idxWithoutConflicts];
            long pointIfIgnore = dp[i + 1];

            dp[i] = Math.max(pointIfIgnore, pointsIfAccept);
        }

        return dp[0];
    }
}
