package MonthlyChallenges.Year23.March;

public class NumberOfWaysOfCuttingPizza {

    /**
     * LeetCode #1444. Number of Ways of Cutting a Pizza.
     *
     * @param pizza - an array of string representing rows of a rectangular pizza.
     *              'A' - means there is an apple on a pizza cell, '.' - means it is an empty cell.
     * @param k     - the number of allowed cuts.
     * @return - the number of ways of cutting the pizza such that each piece contains at least one apple.
     * Result is modulo 1_000_000_007.
     */
    public int ways(String[] pizza, int k) {
        int MODULO = 1_000_000_007;
        int rows = pizza.length;
        int cols = pizza[0].length();

        int[][] applesCount = new int[rows + 1][cols + 1];
        int[][][] dp = new int[k][rows][cols];

        for (int row = rows - 1; row >= 0; row--) {
            for (int col = cols - 1; col >= 0; col--) {
                int isApple = pizza[row].charAt(col) == 'A' ? 1 : 0;

                applesCount[row][col] = isApple + applesCount[row + 1][col] + applesCount[row][col + 1]
                        - applesCount[row + 1][col + 1];
                dp[0][row][col] = applesCount[row][col] > 0 ? 1 : 0;
            }
        }

        for (int cuts = 1; cuts < k; cuts++) {
            for (int row = 0; row < rows; row++) {
                for (int col = 0; col < cols; col++) {
                    for (int nextRow = row + 1; nextRow < rows; nextRow++) {
                        if (applesCount[row][col] - applesCount[nextRow][col] > 0) {
                            dp[cuts][row][col] += dp[cuts - 1][nextRow][col];
                            dp[cuts][row][col] %= MODULO;
                        }
                    }
                    for (int nextCol = col + 1; nextCol < cols; nextCol++) {
                        if (applesCount[row][col] - applesCount[row][nextCol] > 0) {
                            dp[cuts][row][col] += dp[cuts - 1][row][nextCol];
                            dp[cuts][row][col] %= MODULO;
                        }
                    }
                }
            }
        }

        return dp[k - 1][0][0];
    }
}
