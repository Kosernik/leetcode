package Problems;

import java.util.Arrays;

public class MatrixBlockSum {
    public static void main(String[] args) {
        MatrixBlockSum solution = new MatrixBlockSum();

        int[][] test1 = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };

        int[][] res1 = solution.matrixBlockSum(test1, 1);
        solution.prntMtrx(res1);
    }
    private void prntMtrx(int[][] mat) {
        for (int[] row : mat) System.out.println(Arrays.toString(row));
        System.out.println();
    }


    int[][] presums;

    /**
     * LeetCode #1314. Matrix Block Sum.
     *
     * Complexity - O(M*N), M = mat.length, N = mat[0].length.
     * Memory - O(M*N)
     *
     * @param mat - a 2d square matrix.
     * @param k - positive integer.
     * @return - read https://leetcode.com/problems/matrix-block-sum/
     */
    public int[][] matrixBlockSum(int[][] mat, int k) {
        int[][] result = new int[mat.length][mat[0].length];

        presums = new int[mat.length+1][mat[0].length+1];
        fillPresums(mat);

        for (int row = 0; row < mat.length; row++) {
            for (int col = 0; col < mat[0].length; col++) {
                int topLeftRow = Math.max(0, row - k);
                int topLeftCol = Math.max(0, col - k);
                int bottomRightRow = Math.min(mat.length-1, row + k);
                int bottomRightCol = Math.min(mat[0].length-1, col + k);
                result[row][col] = getRangeSum(topLeftRow, topLeftCol, bottomRightRow, bottomRightCol);
            }
        }

        return result;
    }

    private int getRangeSum(int topLeftRow, int topLeftCol, int bottomRightRow, int bottomRightCol) {
        return presums[bottomRightRow+1][bottomRightCol+1] -
                presums[topLeftRow][bottomRightCol+1] - presums[bottomRightRow+1][topLeftCol] +
                presums[topLeftRow][topLeftCol];
    }

    private void fillPresums(int[][] mat) {
        for (int row = 1; row <= mat.length; row++) {
            for (int col = 1; col <= mat[0].length; col++) {
                presums[row][col] = presums[row][col-1] + presums[row-1][col] + mat[row-1][col-1] - presums[row-1][col-1];
            }
        }
    }
}
