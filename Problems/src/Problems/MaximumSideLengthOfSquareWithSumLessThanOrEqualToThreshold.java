package Problems;

public class MaximumSideLengthOfSquareWithSumLessThanOrEqualToThreshold {
    public static void main(String[] args) {
        MaximumSideLengthOfSquareWithSumLessThanOrEqualToThreshold solution =
                new MaximumSideLengthOfSquareWithSumLessThanOrEqualToThreshold();
    }

    /**
     * LeetCode #1292. Maximum Side Length of a Square with Sum Less than or Equal to Threshold.
     *
     *  Complexity - O(N*M + log(Min(N,M))*(N*M)), N = height of the matrix, M = width of the matrix.
     *  Memory - O(N*M)
     *
     * @param mat - a 2d matrix of non-negative integers.
     * @param threshold - a non-negative integers.
     * @return - the maximum side-length of a square with a sum less than or equal to threshold or 0 if there is no such
     *           square.
     */
    public int maxSideLength(int[][] mat, int threshold) {
        int height = mat.length;
        int width = mat[0].length;
        long[][] preSums = new long[height+1][width+1];

        fillPreSums(mat, height, width, preSums);

        int low = 0, high = Math.min(height, width), middle;

        while (low < high) {
            middle = high - (high - low) / 2;

            if (isValidSize(middle, preSums, threshold)) {
                low = middle;
            } else {
                high = middle - 1;
            }
        }

        return low;
    }

    private void fillPreSums(int[][] mat, int height, int width, long[][] preSums) {
        for (int i = 1; i <= width; i++) {
            preSums[1][i] = preSums[1][i-1] + mat[0][i-1];
        }
        for (int i = 2; i <= height; i++) {
            preSums[i][1] = preSums[i-1][1] + mat[i-1][0];
        }
        for (int i = 2; i <= height; i++) {
            for (int j = 2; j <= width; j++) {
                preSums[i][j] = mat[i-1][j-1] + preSums[i-1][j] + preSums[i][j-1] - preSums[i-1][j-1];
            }
        }
    }

    private boolean isValidSize(int candidateSize, long[][] preSums, int threshold) {
        for (int row = candidateSize; row < preSums.length; row++) {
            for (int col = candidateSize; col < preSums[0].length; col++) {
                if (getSquareSum(candidateSize, row, col, preSums) <= threshold) return true;
            }
        }
        return false;
    }

    private long getSquareSum(int size, int row, int col, long[][] preSums) {
        int startRow = row - size;
        int startCol = col - size;

        return preSums[row][col] - preSums[startRow][col] - preSums[row][startCol] + preSums[startRow][startCol];
    }
}
