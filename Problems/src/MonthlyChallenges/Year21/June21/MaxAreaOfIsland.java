package MonthlyChallenges.Year21.June21;

import java.util.ArrayDeque;

public class MaxAreaOfIsland {
    /**
     * LeetCode #695.
     * <p>
     * Complexity - O(m*n)
     * Memory - O(m*n)
     *
     * @param grid - a 2d-array of '0' and '1'.
     * @return - the area of the largest island.
     */
    public int maxAreaOfIsland(int[][] grid) {
        int length = grid.length;
        int width = grid[0].length;
        boolean[][] visited = new boolean[length][width];
        int maxArea = 0;

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < width; j++) {
                if (!visited[i][j]) {
                    if (grid[i][j] == 0) {
                        visited[i][j] = true;
                    } else {
                        maxArea = Math.max(maxArea, getAreaOfAnIsland(grid, visited, i, j));
                    }
                }
            }
        }

        return maxArea;
    }

    private int getAreaOfAnIsland(int[][] grid, boolean[][] visited, int row, int col) {
        int area = 0;

        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{row, col});

        while (!queue.isEmpty()) {
            int[] cell = queue.removeFirst();

            if (visited[cell[0]][cell[1]]) continue;

            visited[cell[0]][cell[1]] = true;
            area++;

            if (cell[0] > 0 && grid[cell[0] - 1][cell[1]] == 1 && !visited[cell[0] - 1][cell[1]]) {
                queue.offerLast(new int[]{cell[0] - 1, cell[1]});
            }
            if (cell[1] > 0 && grid[cell[0]][cell[1] - 1] == 1 && !visited[cell[0]][cell[1] - 1]) {
                queue.offerLast(new int[]{cell[0], cell[1] - 1});
            }
            if (cell[0] < grid.length - 1 && grid[cell[0] + 1][cell[1]] == 1 && !visited[cell[0] + 1][cell[1]]) {
                queue.offerLast(new int[]{cell[0] + 1, cell[1]});
            }
            if (cell[1] < grid[0].length - 1 && grid[cell[0]][cell[1] + 1] == 1 && !visited[cell[0]][cell[1] + 1]) {
                queue.offerLast(new int[]{cell[0], cell[1] + 1});
            }
        }

        return area;
    }
}
