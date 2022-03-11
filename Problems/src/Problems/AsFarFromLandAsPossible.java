package Problems;

import java.util.*;

public class AsFarFromLandAsPossible {

    /**
     * LeetCode #1162. As Far from Land as Possible.
     *
     * Complexity - O(N), N = grid.length * grid[0].length.
     * Memory - O(N)
     *
     * @param grid - a 2d square array of 0 and 1.
     * @return - the maximum Manhattan distance from a cell with 0 to the closest cell with 1.
     */
    public int maxDistance(int[][] grid) {
        int distance = -1;

        ArrayDeque<int[]> queue = new ArrayDeque<>();

        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == 1) queue.offer(new int[] {row, col});
            }
        }

        // No land or no water.
        if (queue.isEmpty() || queue.size() == (grid.length * grid[0].length)) return -1;

        int[] neighbours = {0,1,0,-1,0};
        while (!queue.isEmpty()) {
            distance++;

            for (int i = queue.size(); i > 0; i--) {
                int[] cell = queue.removeFirst();
                int row = cell[0];
                int col = cell[1];

                for (int j = 0, n = 0; j < 4; j++, n++) {
                    int neighRow = row + neighbours[n];
                    int neighCol = col + neighbours[n+1];

                    if (neighRow >= 0 && neighRow < grid.length && neighCol >= 0 && neighCol < grid[0].length &&
                            grid[neighRow][neighCol] == 0) {
                        grid[neighRow][neighCol] = 1;
                        queue.offerLast(new int[] {neighRow, neighCol});
                    }
                }
            }
        }

        return distance;
    }

    public int maxDistanceTLE(int[][] grid) {
        int distance = -1;

        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == 0) {
                    distance = Math.max(distance, bfs(row, col, grid));
                }
            }
        }

        return distance;
    }

    private int bfs(int row, int col , int[][] grid) {
        int distance = 0;

        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {row, col});
        Set<String> visited = new HashSet<>();
        visited.add(row + "*" + col);

        int[] neighbourCoordinates = {0,1,0,-1,0};

        while (!queue.isEmpty()) {
            distance++;
            for (int i = queue.size(); i > 0; i--) {
                int[] cell = queue.removeFirst();
                int curRow = cell[0];
                int curCol = cell[1];

                if (grid[curRow][curCol] == 1) {
                    return distance;
                }

                for (int j = 0, neigh = 0; j < 4; j++, neigh++) {
                    int neighbourRow = curRow + neighbourCoordinates[neigh];
                    int neighbourCol = curCol + neighbourCoordinates[neigh+1];

                    if(isValidNeighbour(neighbourRow, neighbourCol, grid.length, grid[0].length) &&
                            !visited.contains(neighbourRow + "*" + neighbourCol)) {
                        visited.add(neighbourRow + "*" + neighbourCol);
                        queue.offerLast(new int[] {neighbourRow, neighbourCol});
                    }
                }
            }
        }

        return -1;
    }

    private boolean isValidNeighbour(int row, int col, int height, int width) {
        return row >= 0 && row < height && col >= 0 && col < width;
    }
}
