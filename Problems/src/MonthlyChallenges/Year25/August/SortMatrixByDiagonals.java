package MonthlyChallenges.Year25.August;

import java.util.Arrays;

public class SortMatrixByDiagonals {

    /**
     * LeetCode №3446. Sort Matrix by Diagonals.
     * <p>
     * Complexity - O(N*N*logN)
     * Memory - O(N)
     *
     * @param grid - an N*N square array of integers.
     * @return - an array grid with sorted diagonals. The diagonals in the bottom-left triangle (including the middle
     * diagonal) are sorted in non-increasing order. The diagonals in the top-right triangle are sorted in
     * non-decreasing order.
     */
    public int[][] sortMatrix(int[][] grid) {
        int length = grid.length;

        for (int i = 0; i < (length - 1); i++) {
            int row = i;
            int col = 0;

            int[] diagonal = new int[length - i];
            int idx = 0;

            while (row < length) {
                diagonal[idx] = grid[row][col];
                idx++;
                row++;
                col++;
            }

            Arrays.sort(diagonal);

            row = i;
            col = 0;
            idx = diagonal.length - 1;

            while (row < length) {
                grid[row][col] = diagonal[idx];
                row++;
                col++;
                idx--;
            }
        }

        for (int i = 1; i < (length - 1); i++) {
            int row = 0;
            int col = i;

            int[] diagonal = new int[length - i];
            int idx = 0;

            while (col < length) {
                diagonal[idx] = grid[row][col];
                row++;
                col++;
                idx++;
            }

            Arrays.sort(diagonal);

            row = 0;
            col = i;
            idx = 0;

            while (col < length) {
                grid[row][col] = diagonal[idx];
                row++;
                col++;
                idx++;
            }
        }

        return grid;
    }
}
