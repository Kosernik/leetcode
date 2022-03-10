package Problems;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Set;

public class NumberOfEnclaves {

    /**
     * LeetCode #1020. Number of Enclaves.
     *
     * Complexity - O(N*M), N = grid.length, M = grid[0].length.
     * Memory - O(N*M)
     *
     * @param grid - a 2d square array of 0 and 1.
     * @return - the number of enclave cells.
     */
    public int numEnclaves(int[][] grid) {
        Set<String> visited = new HashSet<>();
        int numberOfEnclaves = 0;

        for (int row = 1; row < grid.length-1; row++) {
            for (int col = 1; col < grid[0].length-1; col++) {
                if (grid[row][col] == 1 && !visited.contains(row + "*" + col)) {
                    numberOfEnclaves += bfs(row, col, grid, visited);
                }
            }
        }

        return numberOfEnclaves;
    }

    private int bfs(int row, int col, int[][] grid, Set<String> visited) {
        int count = 0;
        boolean touchingBorder = false;

        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {row, col});
        visited.add(row + "*" + col);

        int[] coordinates = {0,1,0,-1,0};

        while (!queue.isEmpty()) {
            int[] cell = queue.remove();
            int curRow = cell[0];
            int curCol = cell[1];
            count++;

            // Out of the grid.
            if (curRow == 0 || curRow == (grid.length-1) || curCol == 0 || curCol == (grid[0].length-1)) {
                touchingBorder = true;
            }

            for (int i = 0, coordinate = 0; i < 4; i++, coordinate++) {
                int newRow = curRow + coordinates[coordinate];
                int newCol = curCol + coordinates[coordinate+1];

                if (!visited.contains(newRow + "*" + newCol) &&
                        isValidNeighbour(newRow, newCol, grid.length, grid[0].length) &&
                        grid[newRow][newCol] == 1) {
                    visited.add(newRow + "*" + newCol);
                    queue.offer(new int[] {newRow, newCol});
                }
            }
        }

        return touchingBorder ? 0 : count;
    }

    private boolean isValidNeighbour(int row, int col, int height, int width) {
        return row >= 0 && col >= 0 && row < height && col < width;
    }
}
