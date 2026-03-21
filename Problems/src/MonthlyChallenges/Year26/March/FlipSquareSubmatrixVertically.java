package MonthlyChallenges.Year26.March;

public class FlipSquareSubmatrixVertically {

    /**
     * LeetCode №3643. Flip Square Submatrix Vertically.
     * <p>
     * Complexity - O(k^2)
     * Memory - O(1)
     *
     * @param grid - a 2d matrix.
     * @param x    - the coordinate of the top left row coordinate of a square submatrix.
     * @param y    - the coordinate of the top left column coordinate of a square submatrix.
     * @param k    - the side length of the square submatrix.
     * @return - the updated matrix after flipping rows vertically in a square submatrix.
     */
    public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
        for (int i = 0; i < k / 2; i++) {
            int topIdx = x + i;
            int botIdx = x + k - 1 - i;

            for (int j = y; j < y + k; j++) {
                int temp = grid[topIdx][j];
                grid[topIdx][j] = grid[botIdx][j];
                grid[botIdx][j] = temp;
            }
        }

        return grid;
    }
}
