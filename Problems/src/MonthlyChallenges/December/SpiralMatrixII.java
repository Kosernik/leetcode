package MonthlyChallenges.December;

import java.util.Arrays;

public class SpiralMatrixII {
    public static void main(String[] args) {
        SpiralMatrixII solution = new SpiralMatrixII();

        int[][] test0res = solution.generateMatrix(3);
        for (int[] r : test0res) {
            System.out.println(Arrays.toString(r));
        }

        System.out.println("----------");
        int[][] test1res = solution.generateMatrix(4);
        for (int[] r : test1res) {
            System.out.println(Arrays.toString(r));
        }
    }

    /**
     * LeetCode #59.
     *
     * Complexity - O(n*n)
     * Memory - O(n*n)
     *
     * @param n - the size of a matrix (1 <= n <= 20).
     * @return - spiral matrix.
     */
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];

        fillMatrix(matrix, 0, 0, n, 1);

        return matrix;
    }

    private void fillMatrix(int[][] matrix, int row, int col, int n, int startDigit) {
        if (n <= 0) return;
        else if ((4 * (n - 1)) == 0) {
            matrix[row][col] = startDigit;
            return;
        }

        int r = row;
        int c = col;
        int direction = 0;

        for (int i = 0; i < (4 * (n - 1)); i++) {
            matrix[r][c] = startDigit;

            if (direction == 0) {
                if (c+1 == col+n) {
                    direction = 1;
                    r++;
                } else {
                    c++;
                }
            } else if (direction == 1) {
                if (r+1 == row+n) {
                    direction = 2;
                    c--;
                } else {
                    r++;
                }
            } else if (direction == 2) {
                if (c == col) {
                    direction = 3;
                    r--;
                } else {
                    c--;
                }
            } else {
                if (r == row) {
                    direction = 0;
                    c++;
                } else {
                    r--;
                }
            }

            startDigit++;
        }

        fillMatrix(matrix, row+1, col+1, n-2, startDigit);
    }
}
