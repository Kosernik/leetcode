package MonthlyChallenges.Year26.April;

import java.util.Arrays;

public class MaximumPathScoreInGrid {
    public static void main(String[] args) {
        MaximumPathScoreInGrid solution = new MaximumPathScoreInGrid();

        int[][] grid0 = {
                {0, 1},
                {2, 0}
        };
        int k0 = 1;
        int result0 = 2;
        System.out.println(solution.maxPathScore(grid0, k0) == result0);
    }

    /**
     * LeetCode №3742. Maximum Path Score in a Grid.
     * <p>
     * Complexity - O(N*M*K), N = grid.length, M = grid[i].length, K = k
     * memory - O(M*K)
     * <p>
     * You start from the top-left corner (0, 0) and want to reach the bottom-right corner (N - 1, M - 1) by moving only
     * right or down.
     * Each cell contributes a specific score and incurs an associated cost, according to their cell values:
     * * 0: adds 0 to your score and costs 0.
     * * 1: adds 1 to your score and costs 1.
     * * 2: adds 2 to your score and costs 1.
     *
     * @param grid - a 2d matrix of size N*M with values 0, 1, or 2.
     * @param k    - the maximum cost.
     * @return - the maximum score achievable without exceeding a total cost of k, or -1 if no valid path exists.
     */
    public int maxPathScore(int[][] grid, int k) {
        int height = grid.length, width = grid[0].length;

        int[][] prevRowScores = new int[width][k + 1];
        for (int[] row : prevRowScores) Arrays.fill(row, -1);

        for (int row = 0; row < height; row++) {
            int[][] current = new int[width][k + 1];
            for (int[] r : current) Arrays.fill(r, -1);

            for (int col = 0; col < width; col++) {
                int curScore = grid[row][col];
                int curCost = curScore == 0 ? 0 : 1;

                if (row == 0 && col == 0) {
                    current[0][0] = 0;
                    continue;
                }

                for (int cost = curCost; cost <= k; cost++) {
                    int bestScore = -1;

                    if (row > 0 && prevRowScores[col][cost - curCost] != -1) {
                        bestScore = Math.max(bestScore, prevRowScores[col][cost - curCost] + curScore);
                    }
                    if (col > 0 && current[col - 1][cost - curCost] != -1) {
                        bestScore = Math.max(bestScore, current[col - 1][cost - curCost] + curScore);
                    }

                    current[col][cost] = bestScore;
                }
            }

            prevRowScores = current;
        }

        int result = -1;
        for (int cost = 0; cost <= k; cost++) {
            result = Math.max(result, prevRowScores[width - 1][cost]);
        }

        return result;
    }
}
