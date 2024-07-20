package MonthlyChallenges.Year24.July;

public class FindValidMatrixGivenRowAndColumnSums {

    /**
     * LeetCode №1605. Find Valid Matrix Given Row and Column Sums.
     * <p>
     * Complexity - O(N+M), N = rowSum.length. M = colSum.length.
     * Memory - O(1)
     *
     * @param rowSum - an array representing the sum of elements in each row.
     * @param colSum - an array representing the sum of elements in each column.
     * @return - a matrix of non-negative integers of size rowSum.length x colSum.length that satisfies the rowSum and
     * colSum requirements.
     */
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int[][] result = new int[rowSum.length][colSum.length];

        int rowIdx = 0, colIdx = 0;

        while (rowIdx < rowSum.length && colIdx < colSum.length) {
            if (rowSum[rowIdx] < colSum[colIdx]) {
                result[rowIdx][colIdx] = rowSum[rowIdx];
                colSum[colIdx] -= rowSum[rowIdx];
                rowIdx++;
            } else {
                result[rowIdx][colIdx] = colSum[colIdx];
                rowSum[rowIdx] -= colSum[colIdx];
                colIdx++;
            }
        }

        return result;
    }
}
