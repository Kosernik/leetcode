package MonthlyChallenges.Year24.August;

import java.util.Arrays;

public class SpiralMatrixIII {
    public static void main(String[] args) {
        SpiralMatrixIII solution = new SpiralMatrixIII();

        int testRows = 3;
        int testCols = 3;
        int testRStart = 1;
        int testCStart = 1;

        System.out.println(Arrays.deepToString(solution.spiralMatrixIII(testRows, testCols, testRStart, testCStart)));
    }

    private int rows;
    private int cols;

    /**
     * LeetCode №885. Spiral Matrix III.
     * <p>
     * Complexity - O(N*M), N = rows, M = cols.
     * Memory - O(1).
     *
     * @param rows   - the number of rows in a matrix.
     * @param cols   - the number of columns in a matrix.
     * @param rStart - the starting row. 0 <= rStart < rows
     * @param cStart - the starting column. 0 <= cStart < cols
     * @return - an array of coordinates representing the positions of the grid in the order you visited them.
     */
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        this.rows = rows;
        this.cols = cols;
        int totalCells = rows * cols;

        int[][] result = new int[totalCells][];
        result[0] = new int[]{rStart, cStart};

        int curRow = rStart, curCol = cStart;

        int idx = 1;
        int step = 1;
        int horizontalDirection = 1;
        int verticalDirection = 1;

        while (idx < totalCells) {
            for (int j = 0; j < step; j++) {   // horizontal movement
                curCol += horizontalDirection;
                if (isCellValid(curRow, curCol)) {
                    result[idx++] = new int[]{curRow, curCol};

                    if (idx == totalCells) return result;
                }
            }
            horizontalDirection *= -1;

            for (int j = 0; j < step; j++) {   // vertical movement
                curRow += verticalDirection;
                if (isCellValid(curRow, curCol)) {
                    result[idx++] = new int[]{curRow, curCol};

                    if (idx == totalCells) return result;
                }
            }
            verticalDirection *= -1;

            step++;
        }

        return result;
    }

    private boolean isCellValid(int row, int col) {
        return (0 <= row && row < rows && 0 <= col && col < cols);
    }
}
