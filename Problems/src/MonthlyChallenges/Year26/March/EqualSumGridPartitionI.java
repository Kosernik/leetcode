package MonthlyChallenges.Year26.March;

import java.util.Arrays;

public class EqualSumGridPartitionI {

    /**
     * LeetCode №3546. Equal Sum Grid Partition I.
     * <p>
     * Complexity - O(N*M + M), N = grid.length, M = grid[i].length
     * Memory - O(N+M)
     *
     * @param grid - a 2d matrix of positive integers.
     * @return - true if there exists a partition (vertical of horizontal) of a matrix into two sections where the sum
     * of the elements in both sections is equal. False - otherwise.
     */
    public boolean canPartitionGrid(int[][] grid) {
        int height = grid.length, width = grid[0].length;

        long[] rowSums = new long[height];
        long[] colSums = new long[width];

        for (int row = 0; row < height; row++) {
            if (row >= 1) {
                rowSums[row] += rowSums[row - 1];
            }

            for (int col = 0; col < width; col++) {
                rowSums[row] += grid[row][col];
                colSums[col] += grid[row][col];
            }
        }

        if ((rowSums[height - 1] & 1) == 1) return false;  //  Total sum is odd.
        long halfSum = rowSums[height - 1] / 2;

        int idx = Arrays.binarySearch(rowSums, halfSum);
        if (idx >= 0 && rowSums[idx] == halfSum) return true;

        if (colSums[0] == halfSum) return true;
        for (int col = 1; col < width; col++) {
            colSums[col] += colSums[col - 1];

            if (colSums[col] == halfSum) return true;
            else if (colSums[col] > halfSum) return false;
        }

        return false;
    }
}
