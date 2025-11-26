package MonthlyChallenges.Year25.November;

public class PathsInMatrixWhoseSumIsDivisibleByK {

    /**
     * LeetCode №2435. Paths in Matrix Whose Sum Is Divisible by K.
     * <p>
     * Complexity - O(N*M*K), N = grid.length, M = grid[i].length, K = k.
     * Memory - O(N*M*K)
     *
     * @param grid - an N*M matrix of integers.
     * @param k    - a positive integer.
     * @return - the number of paths from grid[0][0] to grid[M-1][N-1] where the sum of the elements on the path is
     * divisible by k. Result is modulo 1_000_000_007.
     */
    public int numberOfPaths(int[][] grid, int k) {
        final int MODULO = 1_000_000_007;

        int height = grid.length, width = grid[0].length;
        int[][][] dp = new int[height][width][k];
        dp[0][0][grid[0][0] % k] = 1;

        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                int curRemainder = grid[row][col] % k;

                if (row > 0) {
                    for (int i = 0; i < k; i++) {
                        int nextK = (i + curRemainder) % k;
                        dp[row][col][nextK] = dp[row - 1][col][i] % MODULO;
                    }
                }
                if (col > 0) {
                    for (int i = 0; i < k; i++) {
                        int nextK = (i + curRemainder) % k;
                        dp[row][col][nextK] = (dp[row][col][nextK] + dp[row][col - 1][i]) % MODULO;
                    }
                }
            }
        }

        return dp[height - 1][width - 1][0];
    }
}
