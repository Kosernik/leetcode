package MonthlyChallenges.Year26.January;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MaximumSquareAreaByRemovingFencesFromField {

    /**
     * LeetCode №2975. Maximum Square Area by Removing Fences From a Field.
     *
     * @param m       - a positive integer denoting the index of the bottom fence. Fences are 1 indexed.
     * @param n       - a positive integer denoting the index of the right fence. Fences are 1 indexed.
     * @param hFences - an array of given horizontal fences.
     * @param vFences - an array of given vertical fences.
     * @return - the maximum area of a square field that can be formed by removing some fences (possibly none) or -1 if
     * it is impossible to make a square field.
     */
    public int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {
        int MODULO = 1_000_000_007;

        int[] horizontals = expand(hFences, m);
        int[] verticals = expand(vFences, n);

        Set<Integer> horizontalGaps = new HashSet<>();
        for (int i = 0; i < horizontals.length - 1; i++) {
            int start = horizontals[i];

            for (int j = i + 1; j < horizontals.length; j++) {
                horizontalGaps.add(horizontals[j] - start);
            }
        }

        long maxLength = -1;

        for (int i = 0; i < verticals.length - 1; i++) {
            int start = verticals[i];

            for (int j = i + 1; j < verticals.length; j++) {
                int curGap = verticals[j] - start;

                if (horizontalGaps.contains(curGap)) {
                    maxLength = Math.max(maxLength, curGap);
                }
            }
        }

        if (maxLength == -1) return -1;

        maxLength = maxLength % MODULO;
        return (int) (maxLength * maxLength % MODULO);
    }

    private int[] expand(int[] fences, int maxSize) {
        Arrays.sort(fences);
        int[] result = new int[fences.length + 2];
        result[0] = 1;
        result[result.length - 1] = maxSize;

        System.arraycopy(fences, 0, result, 1, fences.length);

        return result;
    }
}
