package MonthlyChallenges.Year21.August21;

import java.util.Arrays;

public class StoneGame {
    // LeetCode #877.
    public boolean stoneGame(int[] piles) {
        int[][] computed = new int[piles.length][piles.length];
        for (int[] row : computed) {
            Arrays.fill(row, -1);
        }
        return getResult(piles, 0, piles.length - 1, computed) > 0;
    }

    private int getResult(int[] piles, int startIdx, int endIdx, int[][] computed) {
        if (startIdx > endIdx) return 0;
        else if (computed[startIdx][endIdx] >= 0) return computed[startIdx][endIdx];
        else if (startIdx == endIdx) {
            computed[startIdx][endIdx] = piles[startIdx];
            return piles[startIdx];
        }
        int leftRes = piles[startIdx] - getResult(piles, startIdx + 1, endIdx, computed);
        int rightRes = piles[endIdx] - getResult(piles, startIdx, endIdx - 1, computed);
        int res = Math.max(leftRes, rightRes);
        computed[startIdx][endIdx] = res;
        return res;
    }
}
