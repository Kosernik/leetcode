package MonthlyChallenges.December;

import java.util.Arrays;

public class CherryPickupII {
    // LeetCode #1463.
    public int cherryPickup(int[][] grid) {
        int length = grid.length;
        int width = grid[0].length;
        int[][][] dp = new int[length][width][width];

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < width; j++) {
                Arrays.fill(dp[i][j], Integer.MIN_VALUE);
            }
        }

        return helper(grid, 0, 0, width-1, dp);
    }

    private int helper (int[][] grid, int row, int colR1, int colR2, int[][][] dp) {
        if (colR1 < 0 || colR1 >= grid[0].length || colR2 < 0 || colR2 >= grid[0].length) return 0;
        else if (dp[row][colR1][colR2] != Integer.MIN_VALUE) return dp[row][colR1][colR2];

        int totalCherries = grid[row][colR1];
        if (colR1 != colR2) totalCherries += grid[row][colR2];

        if (row != (grid.length-1)) {
            int cherries = 0;

            for (int nextColR1 = colR1-1; nextColR1 <= (colR1+1); nextColR1++) {
                for (int nextColR2 = colR2-1; nextColR2 <= (colR2+1); nextColR2++) {
                    cherries = Math.max(cherries, helper(grid, row+1, nextColR1, nextColR2, dp));
                }
            }
            totalCherries += cherries;
        }

        dp[row][colR1][colR2] = totalCherries;

        return totalCherries;
    }
}
