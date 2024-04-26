package MonthlyChallenges.Year24.April;

public class MinimumFallingPathSumII {

    /**
     * LeetCode №1289. Minimum Falling Path Sum II.
     * <p>
     * Complexity - O(N*N), N = grid.length.
     * Memory - O(1)
     *
     * @param grid - a square 2d array.
     * @return - the minimum sum of a falling path with non-zero shifts.
     */
    public int minFallingPathSum(int[][] grid) {
        if (grid.length == 1) {
            return grid[0][0];
        }

        int prevMin = 0;
        int prevMinIdx = -1;
        int secondPrevMin = 0;

        for (int[] row : grid) {
            int curMin = Integer.MAX_VALUE;
            int curMinIdx = 0;
            int secondCurMin = Integer.MAX_VALUE;


            for (int i = 0; i < row.length; i++) {
                int curVal = row[i];
                if (i == prevMinIdx) {
                    curVal += secondPrevMin;
                } else {
                    curVal += prevMin;
                }

                if (curVal < curMin) {
                    secondCurMin = curMin;

                    curMin = curVal;
                    curMinIdx = i;
                } else if (curVal < secondCurMin) {
                    secondCurMin = curVal;
                }
            }

            prevMin = curMin;
            prevMinIdx = curMinIdx;
            secondPrevMin = secondCurMin;
        }

        return prevMin;
    }

    /**
     * LeetCode №1289. Minimum Falling Path Sum II.
     * <p>
     * Complexity - O(N^3), N = grid.length.
     * Memory - O(N)
     *
     * @param grid - a square 2d array.
     * @return - the minimum sum of a falling path with non-zero shifts.
     */
    public int minFallingPathSumSlow(int[][] grid) {
        if (grid.length == 1) {
            return grid[0][0];
        }

        int[] prevRow = new int[grid[0].length];


        for (int[] row : grid) {
            int[] nextPrevBest = new int[prevRow.length];

            for (int i = 0; i < nextPrevBest.length; i++) {
                nextPrevBest[i] = row[i] + getMinVal(i, prevRow);
            }

            prevRow = nextPrevBest;
        }

        int result = prevRow[0];
        for (int j : prevRow) {
            result = Math.min(result, j);
        }

        return result;
    }

    private int getMinVal(int idx, int[] row) {
        int minVal = Integer.MAX_VALUE;

        for (int i = 0; i < idx; i++) {
            minVal = Math.min(minVal, row[i]);
        }

        for (int i = idx + 1; i < row.length; i++) {
            minVal = Math.min(minVal, row[i]);
        }

        return minVal;
    }
}
