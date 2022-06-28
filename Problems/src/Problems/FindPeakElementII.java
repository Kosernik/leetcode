package Problems;

public class FindPeakElementII {

    /**
     * LeetCode #1901. Find a Peak Element II.
     *
     * Complexity - O(NlogM), N = mat.length, M = mat[0].length.
     * Memory - O(1)
     *
     * @param mat - a 2d array of integers.
     * @return - the coordinates of a peak in mat.
     */
    public int[] findPeakGrid(int[][] mat) {
        int width = mat[0].length;
        int left = 0, right = width-1;

        while (left <= right) {
            int midCol = (right - left) / 2 + left;

            int maxRowIdx = getMaxIdx(mat, midCol);

            boolean isLeftSideLarger = (midCol-1) >= 0 && mat[maxRowIdx][midCol-1] > mat[maxRowIdx][midCol];
            boolean isRightSideLarger = (midCol+1) < width && mat[maxRowIdx][midCol] < mat[maxRowIdx][midCol+1];

            if (!isLeftSideLarger && !isRightSideLarger) {
                return new int[] {maxRowIdx, midCol};
            }
            else if (isLeftSideLarger) {
                right = midCol - 1;
            } else {
                left = midCol + 1;
            }
        }
        return null;
    }

    private int getMaxIdx(int[][] mat, int col) {
        int maxVal = mat[0][col];
        int idx = 0;

        for (int i = 1; i < mat.length; i++) {
            if (mat[i][col] > maxVal) {
                maxVal = mat[i][col];
                idx = i;
            }
        }

        return idx;
    }
}
