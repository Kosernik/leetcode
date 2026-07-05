package MonthlyChallenges.Year26.July;

import java.util.List;

public class NumberOfPathsWithMaxScore {

    /**
     * LeetCode №1301. Number of Paths with Max Score.
     * <p>
     * Complexity - O(N^2)
     * Memory - O(N^2)
     *
     * @param board - a square board of size N*N.
     *              board.get(0).charAt(0) = 'E' - finish cell, board.get(N-1).charAt(N-1) = 'S' - start cell.
     *              'X' - means the cell is an obstacle, numeric value of a cell is its score.
     * @return - an array of two integers, the first number is the maximum sum of numeric characters you can collect
     * (You can move either up or left or up-left (diagonally)). The second is the number of such paths that you can
     * take to get that maximum sum, taken modulo 10^9 + 7. In case there is no path, returns [0, 0].
     */
    public int[] pathsWithMaxScore(List<String> board) {
        int MODULO = 1_000_000_007;

        char obstacle = 'X';

        int size = board.size();

        char[][] boardValues = new char[size][size];
        for (int i = 0; i < size; i++) {
            boardValues[i] = board.get(i).toCharArray();
        }
        boardValues[size - 1][size - 1] = '0';
        boardValues[0][0] = '0';

        int[][][] dp = new int[size][size][2];
        dp[size - 1][size - 1][1] = 1;

        for (int i = size - 1; i >= 0; i--) {
            for (int j = size - 1; j >= 0; j--) {
                if (boardValues[i][j] == obstacle) continue;

                int maxScore = -1;
                long maxSteps = 0;

                if ((j + 1) < size && dp[i][j + 1][1] != 0) {  //  Right cell
                    maxScore = dp[i][j + 1][0];
                    maxSteps = dp[i][j + 1][1];
                }

                if ((i + 1) < size && dp[i + 1][j][1] != 0) {  //  Bottom cell
                    if (maxScore < dp[i + 1][j][0]) {
                        maxScore = dp[i + 1][j][0];
                        maxSteps = dp[i + 1][j][1];
                    } else if (maxScore == dp[i + 1][j][0]) {
                        maxSteps = (maxSteps + dp[i + 1][j][1]) % MODULO;
                    }
                }

                if (((i + 1) < size && (j + 1) < size) && dp[i + 1][j + 1][1] != 0) {
                    if (maxScore < dp[i + 1][j + 1][0]) {
                        maxScore = dp[i + 1][j + 1][0];
                        maxSteps = dp[i + 1][j + 1][1];
                    } else if (maxScore == dp[i + 1][j + 1][0]) {
                        maxSteps = (maxSteps + dp[i + 1][j + 1][1]) % MODULO;
                    }
                }

                if (maxSteps == 0) continue;

                dp[i][j][0] = maxScore + (boardValues[i][j] - '0');
                dp[i][j][1] = (int) maxSteps;
            }
        }

        return new int[]{dp[0][0][0], dp[0][0][1]};
    }
}
