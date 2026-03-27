package MonthlyChallenges.Year26.March;

public class MatrixSimilarityAfterCyclicShifts {

    /**
     * LeetCode №2946. Matrix Similarity After Cyclic Shifts.
     * <p>
     * Complexity - O(N*M), N = mat.length, M = mat[i].length.
     * Memory - O(M)
     *
     * @param mat - a 2d matrix of integers.
     * @param k   - a positive integer representing the number of shifts.
     * @return - true if the final modified matrix after k shifts is identical to the original matrix. False - otherwise.
     */
    public boolean areSimilar(int[][] mat, int k) {
        int height = mat.length, width = mat[0].length;
        k = k % width;

        if (k == 0) return true;

        boolean left = true;

        for (int row = 0; row < height; row++) {
            int[] shifted;
            if (left) {
                shifted = leftShift(row, mat, k);
            } else {
                shifted = rightShift(row, mat, k);
            }

            left = !left;

            if (!isIdentical(shifted, mat[row])) return false;
        }

        return true;
    }

    private int[] leftShift(int row, int[][] mat, int k) {
        int width = mat[row].length;
        int[] shifted = new int[width];

        for (int col = 0, originalIdx = k; col < width; col++, originalIdx = (originalIdx + 1) % width) {
            shifted[col] = mat[row][originalIdx];
        }

        return shifted;
    }

    private int[] rightShift(int row, int[][] mat, int k) {
        int width = mat[row].length;
        int[] shifted = new int[width];

        for (int col = 0, originalIdx = (width - k); col < width; col++, originalIdx = (originalIdx + 1) % width) {
            shifted[col] = mat[row][originalIdx];
        }

        return shifted;
    }

    private boolean isIdentical(int[] candidate, int[] original) {
        for (int i = 0; i < candidate.length; i++) {
            if (candidate[i] != original[i]) return false;
        }

        return true;
    }
}
