package MonthlyChallenges.Year26.January;

import java.util.Arrays;

public class MaximizeAreaOfSquareHoleInGrid {
    public static void main(String[] args) {
        MaximizeAreaOfSquareHoleInGrid solution = new MaximizeAreaOfSquareHoleInGrid();

        int n3 = 3, m3 = 2;
        int[] hBars3 = {3, 2, 4}, vBars3 = {3, 2};
        int result3 = 9;
        System.out.println(solution.maximizeSquareHoleArea(n3, m3, hBars3, vBars3) == result3);
    }

    /**
     * LeetCode №2943. Maximize Area of Square Hole in Grid.
     * <p>
     * Complexity - O(H*logH + H + V*logV + V), H = hBars.length, V = vBars.length.
     * Memory - O(1)
     *
     * @param n     - a positive integer. The height of a grid is n + 1.
     * @param m     - a positive integer. The width of a grid is m + 1.
     * @param hBars - an array of indexes of horizontal bars that can be removed. The bars are indexed starting from 1.
     * @param vBars - an array of indexes of vertical bars that can be removed. The bars are indexed starting from 1.
     * @return - the maximum area of a square-shaped hole in the grid, after removing some bars (possibly none).
     */
    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
        int maxHeight = getMaxLength(hBars);
        int maxWidth = getMaxLength(vBars);

        int size = Math.min(maxHeight, maxWidth);

        return size * size;
    }

    private int getMaxLength(int[] bars) {
        Arrays.sort(bars);

        int maxLength = 0;

        int prevStart = 0;
        int prevEnd = 0;

        for (int bar : bars) {
            if ((prevEnd + 1) < bar) {
                maxLength = Math.max(maxLength, prevEnd - prevStart + 2);
                prevStart = bar;
            }

            prevEnd = bar;
        }

        maxLength = Math.max(maxLength, prevEnd - prevStart + 2);

        return maxLength;
    }
}
