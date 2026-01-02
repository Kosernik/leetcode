package MonthlyChallenges.Year21.June21;

import java.util.Arrays;

public class MaximumAreaOfAPieceOfCake {
    /**
     * LeetCode #1465.
     * <p>
     * Complexity - O(logN + logM), N - horizontalCuts.length, M - verticalCuts.length.
     * Memory - O(1)
     *
     * @param h              - the height of a "cake".
     * @param w              - the width of a "cake"
     * @param horizontalCuts - an array of distances from the top of the rectangular cake to the i-th horizontal cut .
     * @param verticalCuts   - an array of distances from the left of the rectangular cake to the j-th vertical cut.
     * @return - the maximum area of a piece of cake after you cut at each horizontal and vertical position provided in
     * the arrays horizontalCuts and verticalCuts.
     */
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        int MODULO = 1_000_000_007;
        int lenH = getMaxLength(h, horizontalCuts) % MODULO;
        int lenW = getMaxLength(w, verticalCuts) % MODULO;

        return (int) (((long) lenH * lenW) % MODULO);
    }

    private int getMaxLength(int width, int[] cuts) {
        int maxLength = width - cuts[cuts.length - 1];

        int prev = 0;
        for (int cut : cuts) {
            maxLength = Math.max(maxLength, cut - prev);
            prev = cut;
        }

        return maxLength;
    }
}
