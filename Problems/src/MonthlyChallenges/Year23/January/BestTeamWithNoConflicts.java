package MonthlyChallenges.Year23.January;

import java.util.Arrays;

public class BestTeamWithNoConflicts {

    /**
     * LeetCode #1626. Best Team With No Conflicts.
     * <p>
     * Complexity - O(NlogN + N*N)
     * Memory - O(N)
     *
     * @param scores - an array of positive integers.
     * @param ages   - an array of positive integers.
     * @return - the highest score of a team without age-score conflicts.
     */
    public int bestTeamScore(int[] scores, int[] ages) {
        int length = scores.length;
        int[][] pairs = new int[length][2];
        for (int i = 0; i < length; i++) {
            pairs[i] = new int[]{scores[i], ages[i]};
        }

        Arrays.sort(pairs, (a, b) -> a[1] != b[1] ? Integer.compare(b[1], a[1]) : Integer.compare(b[0], a[0]));

        int bestScore = 0;
        int[] dpArr = new int[length];

        for (int i = 0; i < length; i++) {
            int curScore = pairs[i][0];
            dpArr[i] = curScore;
            for (int j = 0; j < i; j++) {
                if (pairs[j][0] >= curScore) {
                    dpArr[i] = Math.max(dpArr[i], dpArr[j] + curScore);
                }
            }
            bestScore = Math.max(bestScore, dpArr[i]);
        }
        return bestScore;
    }
}
