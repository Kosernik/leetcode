package MonthlyChallenges.May21;

public class RangeSumQuery2DImmutable {
    private final long[][] sums;

    /**
     * LeetCode #304.
     *
     * @param matrix - a 2d array of integers.
     */
    public RangeSumQuery2DImmutable(int[][] matrix) {
        this.sums = new long[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            this.sums[i][0] = matrix[i][0];
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                this.sums[i][j] = this.sums[i][j-1] + matrix[i][j];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        long result = 0;

        for (int row = row1; row <= row2; row++) {
            result += this.sums[row][col2] - (col1 == 0 ? 0 : this.sums[row][col1-1]);
        }

        return (int) result;
    }
}
