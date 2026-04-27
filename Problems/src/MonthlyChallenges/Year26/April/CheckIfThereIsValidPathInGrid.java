package MonthlyChallenges.Year26.April;

import java.util.ArrayDeque;
import java.util.Deque;

public class CheckIfThereIsValidPathInGrid {

    /**
     * LeetCode №1391. Check if There is a Valid Path in a Grid.
     * <p>
     * Complexity - O(N*M), N = grid.length, M = grid[i].length.
     * Memory - O(N*M)
     * <p>
     * Types of cells:
     * * 1 which means a street connecting the left cell and the right cell.
     * * 2 which means a street connecting the upper cell and the lower cell.
     * * 3 which means a street connecting the left cell and the lower cell.
     * * 4 which means a street connecting the right cell and the lower cell.
     * * 5 which means a street connecting the left cell and the upper cell.
     * * 6 which means a street connecting the right cell and the upper cell.
     *
     * @param grid - a 2d array of integers, representing the types of cells. 1 <= grid[i][j] <= 6
     * @return - true if there is a valid path in the grid from cell grid[0][0] to cell grid[N-1][M-1]. False otherwise.
     */
    public boolean hasValidPath(int[][] grid) {
        int[][] neighbours = {
                {0, 1},     // right 0
                {1, 0},     // down  1
                {0, -1},    // left  2
                {-1, 0}     // up    3
        };
        int[][] validOutMoves = {
                {},
                {0, 2},
                {1, 3},
                {1, 2},
                {0, 1},
                {2, 3},
                {0, 3},
        };
        int[][] validInMoves = {
                {},
                {0, 2},
                {1, 3},
                {0, 3},
                {2, 3},
                {0, 1},
                {1, 2},
        };

        int height = grid.length, width = grid[0].length;
        int targetRow = height - 1, targetCol = width - 1;

        boolean[][] visited = new boolean[height][width];
        visited[0][0] = true;

        Deque<int[]> deque = new ArrayDeque<>();
        deque.offer(new int[]{0, 0});

        while (!deque.isEmpty()) {
            int[] coordinate = deque.poll();

            if (coordinate[0] == targetRow && coordinate[1] == targetCol) return true;

            int cellType = grid[coordinate[0]][coordinate[1]];

            for (int i = 0; i < neighbours.length; i++) {
                int[] neighbour = neighbours[i];
                int nextRow = coordinate[0] + neighbour[0];
                int nextCol = coordinate[1] + neighbour[1];

                if (0 <= nextRow && nextRow < height && 0 <= nextCol && nextCol < width &&
                        !visited[nextRow][nextCol]
                ) {
                    int nextCellType = grid[nextRow][nextCol];
                    if (!canConnect(cellType, nextCellType, i, validOutMoves, validInMoves)) continue;

                    deque.offer(new int[]{nextRow, nextCol});
                    visited[nextRow][nextCol] = true;
                }
            }
        }

        return false;
    }

    private boolean canConnect(int cellType, int nextType, int direction, int[][] validOutMoves, int[][] validInMoves) {
        if (validOutMoves[cellType][0] == direction || validOutMoves[cellType][1] == direction) { //  Outgoing direction is valid
            //  Incoming cell can connect
            return validInMoves[nextType][0] == direction || validInMoves[nextType][1] == direction;
        }

        return false;
    }
}
