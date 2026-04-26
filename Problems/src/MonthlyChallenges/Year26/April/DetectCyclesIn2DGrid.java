package MonthlyChallenges.Year26.April;

import java.util.ArrayDeque;
import java.util.Deque;

public class DetectCyclesIn2DGrid {
    public static void main(String[] args) {
        DetectCyclesIn2DGrid solution = new DetectCyclesIn2DGrid();

        char[][] grid0 = {
                {'a', 'a', 'a', 'a'},
                {'a', 'b', 'b', 'a'},
                {'a', 'b', 'b', 'a'},
                {'a', 'a', 'a', 'a'}
        };
        boolean result0 = true;
        System.out.println(solution.containsCycle(grid0) == result0);

        char[][] grid1 = {
                {'c', 'c', 'c', 'a'},
                {'c', 'd', 'c', 'c'},
                {'c', 'c', 'e', 'c'},
                {'f', 'c', 'c', 'c'}
        };
        boolean result1 = true;
        System.out.println(solution.containsCycle(grid1) == result1);

        char[][] grid2 = {
                {'a', 'b', 'b'},
                {'b', 'z', 'b'},
                {'b', 'b', 'a'}
        };
        boolean result2 = false;
        System.out.println(solution.containsCycle(grid2) == result2);

        char[][] grid4 = {
                {'a', 'a', 'a', 'a'},
                {'a', 'b', 'b', 'a'},
                {'a', 'b', 'x', 'f'},
                {'a', 'a', 'a', 'a'}
        };
        boolean result4 = false;
        System.out.println(solution.containsCycle(grid4) == result4);

        char[][] grid5 = {
                {'c', 'a', 'd'},
                {'a', 'a', 'a'},
                {'a', 'a', 'd'},
                {'a', 'c', 'd'},
                {'a', 'b', 'c'}
        };
        boolean result5 = true;
        System.out.println(solution.containsCycle(grid5) == result5);
    }


    private final int[][] neighbours = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    private int height;
    private int width;

    /**
     * LeetCode №1559. Detect Cycles in 2D Grid.
     * <p>
     * Complexity - O(N*M), N = grid.length, M = grid[i].length.
     * Memory - O(N*M)
     *
     * @param grid - a 2d array of characters of size N*M.
     * @return - true if any cycle of the same value exists in grid, otherwise, returns false.
     */
    public boolean containsCycle(char[][] grid) {
        this.height = grid.length;
        this.width = grid[0].length;

        boolean[][] visited = new boolean[height][width];

        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                if (!visited[row][col]) {
                    if (dfs(row, col, grid, visited)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private boolean dfs(int row, int col, char[][] grid, boolean[][] visited) {
        char value = grid[row][col];

        //  {{current Coordinates}, {from Coordinates}}
        Deque<int[][]> queue = new ArrayDeque<>();

        queue.offer(new int[][]{{row, col}, {row, col}});

        while (!queue.isEmpty()) {
            int[][] currentPair = queue.poll();
            int[] current = currentPair[0];
            int[] from = currentPair[1];

            if (visited[current[0]][current[1]]) return true;
            visited[current[0]][current[1]] = true;

            for (int[] neighbour : neighbours) {
                int nextRow = current[0] + neighbour[0];
                int nextCol = current[1] + neighbour[1];

                if (nextRow == from[0] && nextCol == from[1]) continue;
                if (isNeighbourValid(nextRow, nextCol) &&
                        grid[nextRow][nextCol] == value) {
                    queue.offer(new int[][]{{nextRow, nextCol}, current});
                }
            }
        }

        return false;
    }

    private boolean isNeighbourValid(int row, int col) {
        return 0 <= row && row < height && 0 <= col && col < width;
    }
}
