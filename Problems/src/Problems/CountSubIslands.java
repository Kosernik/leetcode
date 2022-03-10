package Problems;

import java.util.ArrayDeque;

public class CountSubIslands {

    /**
     * LeetCode #1905. Count Sub Islands.
     *
     * Complexity - O(N*M), N = grid.length, M = grid[0].length.
     * Memory - O(N*M)
     *
     * @param grid1 - a 2d square array of 0 and 1.
     * @param grid2 - a 2d square array of 0 and 1.
     *              grid1.length == grid2.length
     *              grid1[0].length == grid2[0].length
     *
     * @return - the number of islands in grid2 that are considered sub-islands in grid1.
     */
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int count = 0;

        boolean[][] visited = new boolean[grid1.length][grid1[0].length];

        for (int row = 0; row < grid2.length; row++) {
            for (int col = 0; col < grid2[0].length; col++) {
                if (grid2[row][col] == 1 && !visited[row][col]) {
                    if (isOverlapping(row, col, grid1, grid2, visited)) count++;
                }
            }
        }

        return count;
    }

    private boolean isOverlapping(int row, int col, int[][] grid1, int[][] grid2, boolean[][] visited) {
        boolean fullOverlap = true;

        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {row, col});
        visited[row][col] = true;

        int[] coordinates = {0,1,0,-1,0};

        while (!queue.isEmpty()) {
            int[] cell = queue.remove();
            int curRow = cell[0];
            int curCol = cell[1];

            if (grid1[curRow][curCol] == 0) fullOverlap = false;

            for (int i = 0, coordinate = 0; i < 4; i++, coordinate++) {
                int neighbourRow = curRow + coordinates[coordinate];
                int neighbourCol = curCol + coordinates[coordinate+1];

                if ((neighbourRow >= 0 && neighbourRow < grid2.length &&
                        neighbourCol >= 0 && neighbourCol < grid2[0].length) &&
                        grid2[neighbourRow][neighbourCol] == 1 &&
                        !visited[neighbourRow][neighbourCol]) {

                    visited[neighbourRow][neighbourCol] = true;
                    queue.offer(new int[] { neighbourRow, neighbourCol});
                }
            }
        }

        return fullOverlap;
    }
}
