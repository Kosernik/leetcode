package MonthlyChallenges.Year24.May;

import java.util.Arrays;

public class ScoreAfterFlippingMatrix {
    public static void main(String[] args) {
        ScoreAfterFlippingMatrix solution = new ScoreAfterFlippingMatrix();

        int[][] test0 = {
                {0, 0, 1, 1},
                {1, 0, 1, 0},
                {1, 1, 0, 0}
        };

        System.out.println(solution.matrixScore(test0));
        solution.printGrid(test0);
    }

    /**
     * LeetCode №861. Score After Flipping Matrix.
     * <p>
     * Complexity - O(N*M)
     * Memory - O(1)
     * <p>
     * A move consists of choosing any row or column and toggling each value in that row or column (i.e., changing
     * all 0's to 1's, and all 1's to 0's).
     *
     * @param grid - a binary N*M matrix of 0 and 1.
     * @return - the highest possible score after making any number of moves (including zero moves).
     */
    public int matrixScore(int[][] grid) {
        int height = grid.length;
        int width = grid[0].length;

        int halfHeight = height / 2;
        halfHeight += height % 2 == 0 ? 0 : 1;

        for (int row = 0; row < height; row++) {
            if (grid[row][0] == 0) {
                toggleRow(grid, row);
            }
        }

        for (int col = 0; col < width; col++) {
            int ones = 0;
            for (int i = 0; i < height; i++) {
                ones += grid[i][col];
            }

            if (ones < halfHeight) {
                toggleColumn(grid, col);
            }
        }

        int result = 0;
        for (int[] row : grid) {
            result += convertRowToNumber(row);
        }

        return result;
    }

    private void toggleRow(int[][] grid, int rowIdx) {
        for (int i = 0; i < grid[rowIdx].length; i++) {
            grid[rowIdx][i] = (grid[rowIdx][i] + 1) % 2;
        }
    }

    private void toggleColumn(int[][] grid, int colIdx) {
        for (int i = 0; i < grid.length; i++) {
            grid[i][colIdx] = (grid[i][colIdx] + 1) % 2;
        }
    }

    private int convertRowToNumber(int[] row) {
        int result = 0;
        int width = row.length;

        for (int i = 0; i < width; i++) {
            result |= (row[i] << (width - i - 1));
        }

        return result;
    }

    private void printGrid(int[][] grid) {
        for (int[] row : grid) {
            System.out.println(Arrays.toString(row));
        }
    }
}
