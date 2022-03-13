package Problems;

import java.util.ArrayDeque;

public class ShortestBridge {
    public static void main(String[] args) {
        ShortestBridge solution = new ShortestBridge();

        int[][] test1 = {
                {0,1,0},
                {0,0,0},
                {0,0,1}
        };
        System.out.println(solution.shortestBridge(test1));
        System.out.println();

        int[][] test2 = {
                {1,1,1,1,1},
                {1,0,0,0,1},
                {1,0,1,0,1},
                {1,0,0,0,1},
                {1,1,1,1,1}
        };
        System.out.println(solution.shortestBridge(test2));
    }

    /**
     * LeetCode #934. Shortest Bridge.
     *
     * Complexity - O(N*M), N = grid.length, M = grid[0].length.
     * Memory - O(N*M)
     *
     * @param grid - a 2D array of 0 and 1. Grid always have exactly two islands of 1`s.
     * @return - the shortest bridge between 2 islands on a grid.
     */
    public int shortestBridge(int[][] grid) {
        ArrayDeque<int[]> queue = findAndMarkIsland(grid, 2);

        undoWater(grid);

        int result = -1;
        int[] neighbours = {0, 1, 0, -1, 0};

        while (!queue.isEmpty()) {
            result++;

            for (int i = queue.size(); i > 0; i--) {
                int[] cell = queue.removeFirst();

                for (int j = 0, n = 0; j < 4; j++, n++) {
                    int neighRow = cell[0] + neighbours[n];
                    int neighCol = cell[1] + neighbours[n+1];

                    if (neighRow >= 0 && neighRow < grid.length && neighCol >= 0 && neighCol < grid[0].length) {
                        if (grid[neighRow][neighCol] == 0) {
                            queue.offerLast(new int[]{neighRow, neighCol});
                            grid[neighRow][neighCol] = -1;
                        } else if (grid[neighRow][neighCol] == 1) {
                            return result;
                        }
                    }
                }
            }
        }

        return -1;
    }

    private ArrayDeque<int[]> findAndMarkIsland(int[][] grid, int marker) {
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == 1) {
                    ArrayDeque<int[]> shore = markIsland(row, col, grid, marker);
                    return shore;
                }
            }
        }

        // If no island found on a grid.
        return new ArrayDeque<>();
    }

    private ArrayDeque<int[]> markIsland(int row, int col, int[][] grid, int marker) {
        ArrayDeque<int[]> shore = new ArrayDeque<>();
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{row, col});
        grid[row][col] = marker;

        int[] neighbours = {0, 1, 0, -1, 0};

        while (!queue.isEmpty()) {
            int[] cell = queue.remove();
            boolean touchingWater = false;

            for (int i = 0, n = 0; i < 4; i++, n++) {
                int neighRow = cell[0] + neighbours[n];
                int neighCol = cell[1] + neighbours[n + 1];

                if (neighRow >= 0 && neighRow < grid.length && neighCol >= 0 && neighCol < grid[0].length) {
                    if (grid[neighRow][neighCol] == 1) {
                        grid[neighRow][neighCol] = marker;
                        queue.offer(new int[]{neighRow, neighCol});
                    } else if (grid[neighRow][neighCol] == 0) {
                        touchingWater = true;
                        grid[neighRow][neighCol] = -1;
                    }
                }
            }

            if (touchingWater) shore.offerLast(cell);
        }

        return shore;
    }

    private void undoWater(int[][] grid) {
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == -1) grid[row][col] = 0;
            }
        }
    }
}
