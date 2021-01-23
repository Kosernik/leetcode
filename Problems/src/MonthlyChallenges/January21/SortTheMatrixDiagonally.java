package MonthlyChallenges.January21;

import java.util.Arrays;

public class SortTheMatrixDiagonally {

    private int height;
    private int width;

    /**
     * LeetCode #1329.
     *
     * Sorts each diagonal in a matrix and returns sorted copy of a matrix.
     *
     * Complexity - O(MlogD). M - number of diagonals, D - size of a diagonal.
     * Memory - O(N)
     *
     * @param mat - 2d array of integers.
     * @return - sorted copy of a given 2d array.
     */
    public int[][] diagonalSort(int[][] mat) {
        this.height = mat.length;
        this.width = mat[0].length;

        int[][] sorted = new int[height][width];

        for (int i = 0; i < height; i++) {
            int[] currDiagonal = getDiagonal(new int[]{i,0}, mat);
            Arrays.sort(currDiagonal);
            writeToMatrix(new int[]{i,0}, currDiagonal, sorted);
        }
        for (int j = 1; j < width; j++) {
            int[] currDiagonal = getDiagonal(new int[]{0, j}, mat);
            Arrays.sort(currDiagonal);
            writeToMatrix(new int[]{0, j}, currDiagonal, sorted);
        }

        return sorted;
    }

    private int[] getDiagonal(int[] diagonalStart, int[][] mat) {
        int size = Math.min(this.height - diagonalStart[0], this.width - diagonalStart[1]);
        int[] diagonal = new int[size];
        int row = diagonalStart[0];
        int col = diagonalStart[1];

        for (int i = 0; i < size; i++) {
            diagonal[i] = mat[row++][col++];
        }

        return diagonal;
    }

    private void writeToMatrix(int[] diagonalStart, int[] diagonal, int[][] mat) {
        int row = diagonalStart[0];
        int col = diagonalStart[1];

        for (int j : diagonal) {
            mat[row++][col++] = j;
        }
    }
}
