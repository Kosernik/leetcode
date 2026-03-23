package MonthlyChallenges.Year26.March;

public class MaximumNonNegativeProductInMatrix {
    public static void main(String[] args) {
        MaximumNonNegativeProductInMatrix solution = new MaximumNonNegativeProductInMatrix();

        int[][] grid0 = {
                {-1, -2, -3},
                {-2, -3, -3},
                {-3, -3, -2}
        };
        int result0 = -1;
        System.out.println(solution.maxProductPath(grid0) == result0);

        int[][] grid1 = {
                {1, -2, 1},
                {1, -2, 1},
                {3, -4, 1}
        };
        int result1 = 8;
        System.out.println(solution.maxProductPath(grid1) == result1);

        int[][] grid2 = {
                {1, 3},
                {0, -4}
        };
        int result2 = 0;
        System.out.println(solution.maxProductPath(grid2) == result2);
    }

    /**
     * LeetCode №1594. Maximum Non Negative Product in a Matrix.
     * <p>
     * Complexity - O(N*M), N = grid.length, M = grid[i].length
     * Memory - O(N*M)
     *
     * @param grid - a 2d matrix of size N*M.
     * @return - the maximum non-negative product of a path from grid[0][0] to grid[N-1][M-1] or -1 if the maximum
     * product is negative, result is modulo 1_000_000_007.
     */
    public int maxProductPath(int[][] grid) {
        int MODULO = 1_000_000_007;
        int height = grid.length, width = grid[0].length;

        //  dp[i][j][0] - min number
        //  dp[i][j][1] - max number
        long[][][] dp = new long[height][width][2];
        dp[0][0][0] = grid[0][0];
        dp[0][0][1] = grid[0][0];

        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                if (col == 0 && row == 0) continue;

                int curNumber = grid[row][col];

                long curMin = Long.MAX_VALUE;
                long curMax = Long.MIN_VALUE;

                if (col > 0) {
                    curMin = Math.min(curMin, dp[row][col - 1][0] * curNumber);
                    curMin = Math.min(curMin, dp[row][col - 1][1] * curNumber);
                    curMax = Math.max(curMax, dp[row][col - 1][0] * curNumber);
                    curMax = Math.max(curMax, dp[row][col - 1][1] * curNumber);
                }

                if (row > 0) {
                    curMin = Math.min(curMin, dp[row - 1][col][0] * curNumber);
                    curMin = Math.min(curMin, dp[row - 1][col][1] * curNumber);
                    curMax = Math.max(curMax, dp[row - 1][col][0] * curNumber);
                    curMax = Math.max(curMax, dp[row - 1][col][1] * curNumber);
                }

                dp[row][col][0] = curMin;
                dp[row][col][1] = curMax;
            }
        }

        if (dp[height - 1][width - 1][1] < 0) {
            return -1;
        } else {
            return (int) (dp[height - 1][width - 1][1] % MODULO);
        }
    }
}
