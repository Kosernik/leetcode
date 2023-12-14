package MonthlyChallenges.Year23.December;

public class DifferenceBetweenOnesAndZerosInRowAndColumn {

    /**
     * LeetCode №2482. Difference Between Ones and Zeros in Row and Column.
     * <p>
     * Complexity - O(m*n)
     * Memory - O(1)
     *
     * @param grid - an m*n array of 0 and 1.
     * @return - the difference matrix.
     */
    public int[][] onesMinusZeros(int[][] grid) {
        int height = grid.length, width = grid[0].length;
        int[][] result = new int[height][width];

        int[] rowDiffs = new int[height];
        int[] colDiffs = new int[width];

        for (int r = 0; r < height; r++) {
            for (int c = 0; c < width; c++) {
                if (grid[r][c] == 0) {
                    rowDiffs[r]--;
                    colDiffs[c]--;
                } else {
                    rowDiffs[r]++;
                    colDiffs[c]++;
                }
            }
        }

        for (int r = 0; r < height; r++) {
            for (int c = 0; c < width; c++) {
                result[r][c] = rowDiffs[r] + colDiffs[c];
            }
        }

        return result;
    }
}
