package MonthlyChallenges.Year24.September;

public class Convert1DArrayInto2DArray {

    /**
     * LeetCode №2022. Convert 1D Array Into 2D Array.
     * <p>
     * Complexity - O(m*n)
     * Memory - O(1)
     *
     * @param original - an array of integers.
     * @param m        - the number of row in a result array.
     * @param n        - the number of columns in a result array.
     * @return - a 2D array with m rows and n columns with all the elements from original array.
     */
    public int[][] construct2DArray(int[] original, int m, int n) {
        if (m * n != original.length) return new int[][]{};

        int[][] result = new int[m][n];
        int idx = 0;

        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                result[row][col] = original[idx++];
            }
        }

        return result;
    }
}
