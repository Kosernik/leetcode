package MonthlyChallenges.Year26.March;

import java.util.Arrays;

public class LargestSubmatrixWithRearrangements {

    /**
     * LeetCode №1727. Largest Submatrix With Rearrangements.
     * <p>
     * Complexity - O(N * MlogM), N = matrix.length, M = matrix[0].length.
     * Memory - O(M)
     *
     * @param matrix - a 2d matrix of 0 and 1.
     * @return - the area of the largest submatrix within matrix where every element of the submatrix is 1 after
     * reordering the columns optimally.
     */
    public int largestSubmatrix(int[][] matrix) {
        int maxArea = 0;

        int width = matrix[0].length;

        int[] prevRow = new int[width];
        int[] curRow = new int[width];

        for (int[] row : matrix) {
            for (int col = 0; col < width; col++) {
                if (row[col] == 0) {
                    prevRow[col] = 0;
                    curRow[col] = 0;
                } else {
                    prevRow[col]++;
                    curRow[col] = prevRow[col];
                }
            }

            Arrays.sort(curRow);
            for (int j = width - 1; j >= 0 && curRow[j] > 0; j--) {
                maxArea = Math.max(maxArea, (width - j) * curRow[j]);
            }
        }

        return maxArea;
    }
}
