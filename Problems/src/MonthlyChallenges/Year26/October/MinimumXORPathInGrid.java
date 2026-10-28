package MonthlyChallenges.Year26.October;

public class MinimumXORPathInGrid {

    /**
     * LeetCode №3882. Minimum XOR Path in a Grid.
     * <p>
     * Complexity - O(N*M*K), N = grid.length, M = grid[i].length, K = max number in grid.
     *
     * @param grid - a 2d array of non-negative integers. 0 <= grid[i][j] <= 1023
     * @return - the minimum possible XOR value among all valid paths from (0, 0) to (m - 1, n - 1).
     */
    public int minCost(int[][] grid) {
        int maxNumber = 1024;
        int height = grid.length, width = grid[0].length;
        boolean[][][] dpArr = new boolean[height][width][maxNumber];

        int xor = grid[0][0];
        dpArr[0][0][xor] = true;
        for (int col = 1; col < width; col++) {
            xor ^= grid[0][col];
            dpArr[0][col][xor] = true;
        }

        xor = grid[0][0];
        for (int row = 1; row < height; row++) {
            xor ^= grid[row][0];
            dpArr[row][0][xor] = true;
        }

        for (int row = 1; row < height; row++) {
            for (int col = 1; col < width; col++) {
                int curNumber = grid[row][col];
                for (int i = 0; i < maxNumber; i++) {
                    if (dpArr[row - 1][col][i]) {
                        dpArr[row][col][i ^ curNumber] = true;
                    }
                    if (dpArr[row][col - 1][i]) {
                        dpArr[row][col][i ^ curNumber] = true;
                    }
                }
            }
        }

        for (int i = 0; i < maxNumber; i++) {
            if (dpArr[height - 1][width - 1][i]) return i;
        }
        return -1;
    }
}
