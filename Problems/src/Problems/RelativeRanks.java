package Problems;

import java.util.Arrays;

public class RelativeRanks {
    /**
     * LeetCode #506. Relative Ranks.
     *
     * @param score - an array of points, all points are unique.
     * @return - the array of ranks of athletes.
     */
    public String[] findRelativeRanks(int[] score) {
        int[][] valToIdx = new int[score.length][2];
        String[] medals = {"Gold Medal", "Silver Medal", "Bronze Medal"};

        for (int i = 0; i < score.length; i++) {
            valToIdx[i][0] = score[i];
            valToIdx[i][1] = i;
        }

        Arrays.sort(valToIdx, (a, b) -> Integer.compare(b[0], a[0]));

        String[] result = new String[score.length];
        for (int i = 0; i < Math.min(3, score.length); i++) {
            int idx = valToIdx[i][1];
            result[idx] = medals[i];
        }
        for (int i = 3; i < score.length; i++) {
            int idx = valToIdx[i][1];
            result[idx] = String.valueOf(i+1);
        }
        return result;
    }
}
