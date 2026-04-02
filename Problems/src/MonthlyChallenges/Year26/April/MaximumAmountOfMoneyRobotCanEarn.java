package MonthlyChallenges.Year26.April;

import java.util.Arrays;

public class MaximumAmountOfMoneyRobotCanEarn {
    public static void main(String[] args) {
        MaximumAmountOfMoneyRobotCanEarn solution = new MaximumAmountOfMoneyRobotCanEarn();

        int[][] coins0 = {{0, 1, -1}, {1, -2, 3}, {2, -3, 4}};
        int result0 = 8;
        System.out.println(solution.maximumAmount(coins0) == result0);

        int[][] coins425 = {{-7, 12, 12, 13}, {-6, 19, 19, -6}, {9, -2, -10, 16}, {-4, 14, -10, -9}};
        int result425 = 60;
        System.out.println(solution.maximumAmount(coins425) == result425);
    }

    /**
     * LeetCode №3418. Maximum Amount of Money Robot Can Earn.
     *
     * @param coins - a 2d grid of integers.
     * @return - the maximum profit the robot can gain on the route using at most 2 neutralizes.
     */
    public int maximumAmount(int[][] coins) {
        int NUMBER_OF_NEUTRALIZES = 2;

        int height = coins.length, width = coins[0].length;

        int[][][] dp = new int[height][width][NUMBER_OF_NEUTRALIZES + 1];
        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                Arrays.fill(dp[row][col], Integer.MIN_VALUE);
            }
        }

        return bfs(0, 0, 2, coins, dp);
    }

    private int bfs(int row, int col, int neutralizes, int[][] coins, int[][][] dp) {
        if (row >= coins.length || col >= coins[0].length) return Integer.MIN_VALUE;

        int curCoins = coins[row][col];

        if (row == (coins.length - 1) && col == (coins[0].length - 1)) {
            if (neutralizes > 0) {
                return Math.max(0, curCoins);
            } else {
                return curCoins;
            }
        }

        if (dp[row][col][neutralizes] != Integer.MIN_VALUE) return dp[row][col][neutralizes];

        int result = curCoins + Math.max(
                bfs(row + 1, col, neutralizes, coins, dp),
                bfs(row, col + 1, neutralizes, coins, dp));

        if (neutralizes > 0 && curCoins < 0) {
            int neutralize = Math.max(
                    bfs(row + 1, col, neutralizes - 1, coins, dp),
                    bfs(row, col + 1, neutralizes - 1, coins, dp));
            result = Math.max(result, neutralize);
        }

        dp[row][col][neutralizes] = result;
        return result;
    }
}
