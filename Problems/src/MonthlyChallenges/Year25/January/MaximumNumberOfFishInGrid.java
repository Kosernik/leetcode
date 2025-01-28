package MonthlyChallenges.Year25.January;

import java.util.ArrayDeque;
import java.util.Deque;

public class MaximumNumberOfFishInGrid {
    private final int[][] NEIGHBOURS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    /**
     * LeetCode №2658. Maximum Number of Fish in a Grid.
     * <p>
     * Complexity - O(N)
     * Memory - O(N)
     *
     * @param grid - a 2d array where: grid[i][j] = 0 is a land cell, grid[i][j] > 0 - is a cell with fish.
     * @return - the maximum number of fish the fisher can catch if he chooses his starting cell optimally, or 0 if no
     * water cell exists.
     */
    public int findMaxFish(int[][] grid) {
        int maxFish = 0;

        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] > 0) {
                    maxFish = Math.max(maxFish, countFish(r, c, grid));
                }
            }
        }

        return maxFish;
    }

    private int countFish(int row, int column, int[][] grid) {
        int length = grid.length, width = grid[0].length;
        int fish = 0;

        Deque<int[]> deque = new ArrayDeque<>();
        deque.push(new int[]{row, column});

        while (!deque.isEmpty()) {
            int[] coordinates = deque.pop();
            int r = coordinates[0], c = coordinates[1];

            if (grid[r][c] == 0) continue;
            fish += grid[r][c];
            grid[r][c] = 0;

            for (int[] neighbour : NEIGHBOURS) {
                int nextRow = r + neighbour[0];
                int nextColumn = c + neighbour[1];
                if (0 <= nextRow && nextRow < length && 0 <= nextColumn && nextColumn < width
                        && grid[nextRow][nextColumn] > 0) {
                    deque.push(new int[]{nextRow, nextColumn});
                }
            }
        }

        return fish;
    }
}
