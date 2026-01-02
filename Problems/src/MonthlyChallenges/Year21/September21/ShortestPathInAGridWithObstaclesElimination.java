package MonthlyChallenges.Year21.September21;

import java.util.ArrayDeque;
import java.util.Arrays;

public class ShortestPathInAGridWithObstaclesElimination {
    /**
     * LeetCode #1293. Shortest Path in a Grid with Obstacles Elimination.
     *
     * @param grid - an array of '0' and '1', '0' - empty cell, '1' - obstacle.
     * @param k    - the maximum number of eliminations.
     * @return - the shortest path  from grid[0][0] to grid[grid.length-1][grid[0].length-1].
     */
    public int shortestPath(int[][] grid, int k) {
        int length = grid.length;
        int width = grid[0].length;
        int[][][] dp = new int[length][width][k + 1];

        for (int r = 0; r < length; r++) {
            for (int c = 0; c < width; c++) {
                Arrays.fill(dp[r][c], Integer.MAX_VALUE);
            }
        }
        Arrays.fill(dp[0][0], 0);

        int result = Integer.MAX_VALUE;
        ArrayDeque<int[]> stack = new ArrayDeque<>();
        // {row, col, eliminations, length}
        stack.push(new int[]{0, 0, 0, 0});

        while (!stack.isEmpty()) {
            int[] curCell = stack.pop();
            int row = curCell[0];
            int col = curCell[1];

            if (curCell[3] >= result) continue;
            if (row == length - 1 && col == width - 1) {
                result = curCell[3];
            }
            // increasing length
            curCell[3]++;
            int curLength = curCell[3];

            if (grid[curCell[0]][curCell[1]] == 1) {
                curCell[2]++;
                if (curCell[2] > k) continue;
            }
            int curK = curCell[2];

            //top
            if (row - 1 >= 0 && curLength < dp[row - 1][col][curK]) {
                dp[row - 1][col][curK] = curLength;
                stack.push(new int[]{row - 1, col, curK, curLength});
            }

            //right
            if (col + 1 < width && curLength < dp[row][col + 1][curK]) {
                dp[row][col + 1][curK] = curLength;
                stack.push(new int[]{row, col + 1, curK, curLength});
            }

            //bottom
            if (row + 1 < length && curLength < dp[row + 1][col][curK]) {
                dp[row + 1][col][curK] = curLength;
                stack.push(new int[]{row + 1, col, curK, curLength});
            }

            //left
            if (col - 1 >= 0 && curLength < dp[row][col - 1][curK]) {
                dp[row][col - 1][curK] = curLength;
                stack.push(new int[]{row, col - 1, curK, curLength});
            }
        }

        return result == Integer.MAX_VALUE ? -1 : result;
    }
}
