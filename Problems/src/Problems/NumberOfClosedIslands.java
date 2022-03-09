package Problems;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Set;

public class NumberOfClosedIslands {
    //[[1,1,0,1,1,1,1,1,1,1],       [1,1,*,1,1,1,1,1,1,1]
    // [0,0,1,0,0,1,0,1,1,1],       [*,*,1,+,+,1,+,1,1,1]
    // [1,0,1,0,0,0,1,0,1,0],       [1,*,1,+,+,+,1,+,1,*]
    // [1,1,1,1,1,0,0,1,0,0],       [1,1,1,1,1,+,+,1,*,*]
    // [1,0,1,0,1,1,1,1,1,0],       [1,*,1,*,1,1,1,1,1,*]
    // [0,0,0,0,1,1,0,0,0,0],       [*,*,*,*,1,1,*,*,*,*]
    // [1,0,1,0,0,0,0,1,1,0],       [1,*,1,*,*,*,*,1,1,*]
    // [1,1,0,0,1,1,0,0,0,0],       [1,1,*,*,1,1,*,*,*,*]
    // [0,0,0,1,1,0,1,1,1,0],       [*,*,*,1,1,+,1,1,1,*]
    // [1,1,0,1,0,1,0,0,1,0]]       [1,1,*,1,*,1,*,*,1,*]
    public static void main(String[] args) {
        NumberOfClosedIslands solution = new NumberOfClosedIslands();

        int[][] test = {
                {1,1,0,1,1,1,1,1,1,1},
                {0,0,1,0,0,1,0,1,1,1},
                {1,0,1,0,0,0,1,0,1,0},
                {1,1,1,1,1,0,0,1,0,0},
                {1,0,1,0,1,1,1,1,1,0},
                {0,0,0,0,1,1,0,0,0,0},
                {1,0,1,0,0,0,0,1,1,0},
                {1,1,0,0,1,1,0,0,0,0},
                {0,0,0,1,1,0,1,1,1,0},
                {1,1,0,1,0,1,0,0,1,0}
        };

        System.out.println(solution.closedIsland(test) == 4);
    }

    /**
     * LeetCode #1254. Number of Closed Islands.
     *
     * Complexity - O(N*M), N = grid.length, M = grid[0].length.
     * Memory - (N*M)
     *
     * @param grid - a 2d array of 0 and 1.
     * @return - the number of closed islands.
     */
    public int closedIsland(int[][] grid) {
        int result = 0;
        Set<String> visited = new HashSet<>();

        for (int row = 1; row < grid.length-1; row++) {
            for (int col = 1; col < grid[0].length-1; col++) {
                if (grid[row][col] == 0 && !visited.contains(row + "*" + col) && isClosed(row, col, grid, visited)) {
                    result++;
                }
            }
        }

        return result;
    }

    private boolean isClosed(int row, int col, int[][] grid, Set<String> visited) {
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {row, col});
        visited.add(row + "*" + col);
        int[] coordinates = {0,1,0,-1,0};
        boolean result = true;

        while (!queue.isEmpty()) {
            int[] curCell = queue.remove();
            int curRow = curCell[0];
            int curCol = curCell[1];

            for (int i = 0, coor = 0; i < 4; i++, coor++) {
                int neighbourRow = curRow + coordinates[coor];
                int neighbourCol = curCol + coordinates[coor+1];

                //Current cell is touching the border.
                if (neighbourRow < 0 || neighbourRow == grid.length ||
                        neighbourCol < 0 || neighbourCol == grid[0].length) {
                    result = false;
                    continue;
                }

                if (grid[neighbourRow][neighbourCol] == 0 && !visited.contains(neighbourRow + "*" + neighbourCol)) {
                    visited.add(neighbourRow + "*" + neighbourCol);
                    queue.offer(new int[] {neighbourRow ,neighbourCol});
                }
            }
        }

        return result;
    }
}
