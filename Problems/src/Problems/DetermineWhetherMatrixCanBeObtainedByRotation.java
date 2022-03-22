package Problems;

import java.util.Arrays;

public class DetermineWhetherMatrixCanBeObtainedByRotation {
    public static void main(String[] args) {
        DetermineWhetherMatrixCanBeObtainedByRotation solution = new DetermineWhetherMatrixCanBeObtainedByRotation();
    }

    /**
     * LeetCode #1886. Determine Whether Matrix Can Be Obtained By Rotation.
     *
     * Complexity - O(N), N = the number of cells in a matrix.
     * Memory - O(1)
     *
     * @param mat - a square matrix.
     * @param target - a square matrix.
     * @return - True if it is possible to make mat equal to target by rotating mat in 90-degree increments.
     *           False otherwise.
     */
    public boolean findRotation(int[][] mat, int[][] target) {
        if (sameMatrices(mat, target)) return true;

        // 1-st rotation af a matrix 90 degree
        rotate90degree(mat);
        if (sameMatrices(mat, target)) return true;

        // 2-nd rotation af a matrix 90 degree
        rotate90degree(mat);
        if (sameMatrices(mat, target)) return true;

        // 3-d rotation af a matrix 90 degree
        rotate90degree(mat);
        if (sameMatrices(mat, target)) return true;

        // target is not rotated mat
        return false;
    }

    private void rotate90degree(int[][] mat) {
        int length = mat.length;
        for (int row = 0; row < length/2; row++) {
            for (int col = row; col < (length - row - 1); col++) {
                int prev = mat[length-col-1][row];
                mat[length-col-1][row] = mat[length-row-1][length-col-1];
                mat[length-row-1][length-col-1] = mat[col][length-row-1];
                mat[col][length-row-1] = mat[row][col];
                mat[row][col] = prev;
            }
        }
    }

    private boolean sameMatrices(int[][] mat, int[][] target) {
        for (int row = 0; row < mat.length; row++) {
            for (int col = 0; col < mat[0].length; col++) {
                if (mat[row][col] != target[row][col]) return false;
            }
        }
        return true;
    }

    private void printMatrix(int[][] mat) {
        for (int[] row : mat) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println();
    }
}
