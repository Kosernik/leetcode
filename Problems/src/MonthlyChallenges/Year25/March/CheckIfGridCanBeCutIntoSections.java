package MonthlyChallenges.Year25.March;

import java.util.Arrays;
import java.util.Comparator;

public class CheckIfGridCanBeCutIntoSections {

    /**
     * LeetCode №3394. Check if Grid can be Cut into Sections.
     * <p>
     * Complexity - O(NlogN)
     * Memory - O(sorting algorithm complexity)
     *
     * @param n          - the dimension of the grid (the grid is n*n size).
     * @param rectangles - an array of coordinates of rectangles. rectangles[i] is [start-x, start-y, end-x, end-y].
     * @return - true if it is possible to make either two horizontal or two vertical cuts on the grid such that:
     * - Each of the three resulting sections formed by the cuts contains at least one rectangle.
     * - Every rectangle belongs to exactly one section.
     * Returns false if it is impossible to make two cuts.
     */
    public boolean checkValidCuts(int n, int[][] rectangles) {
        if (hasTwoLines(rectangles, true)) return true;

        return hasTwoLines(rectangles, false);
    }

    private boolean hasTwoLines(int[][] rectangles, boolean horizontal) {
        int numberOfLinesNeeded = 2;

        int firstIdx, secondIdx;
        if (horizontal) {
            firstIdx = 0;
            secondIdx = 2;
        } else {
            firstIdx = 1;
            secondIdx = 3;
        }

        Arrays.sort(rectangles, Comparator.comparingInt(a -> a[firstIdx]));

        int lines = 0;
        int prev = rectangles[0][secondIdx];

        for (int[] rectangle : rectangles) {
            if (rectangle[firstIdx] >= prev) {
                lines++;

                if (lines == numberOfLinesNeeded) return true;
            }

            prev = Math.max(prev, rectangle[secondIdx]);
        }

        return false;
    }
}
