package MonthlyChallenges.Year24.November;

public class MaximumMatrixSum {

    /**
     * LeetCode №1975. Maximum Matrix Sum.
     * <p>
     * Complexity - O(N*M)
     * Memory - O(1)
     * <p>
     * An operation: choose any two adjacent elements of matrix and multiply each of them by -1.
     *
     * @param matrix - a 2d array.
     * @return - the maximum sum of the matrix's elements using the operation mentioned above.
     */
    public long maxMatrixSum(int[][] matrix) {
        long sum = 0L;
        int minAbsValue = Math.abs(matrix[0][0]);
        boolean evenMinuses = true;

        for (int[] row : matrix) {
            for (int val : row) {
                if (val < 0) evenMinuses = !evenMinuses;

                int absVal = Math.abs(val);

                sum += absVal;

                minAbsValue = Math.min(minAbsValue, absVal);
            }
        }

        if (!evenMinuses) {
            sum = sum - 2L * minAbsValue;
        }

        return sum;
    }
}
