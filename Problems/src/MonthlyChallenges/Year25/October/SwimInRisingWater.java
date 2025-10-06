package MonthlyChallenges.Year25.October;

import java.util.Comparator;
import java.util.PriorityQueue;

public class SwimInRisingWater {

    /**
     * LeetCode №778. Swim in Rising Water.
     * <p>
     * Complexity - O(N*logN), N = grid height * grid width = total number of elements in a matrix.
     * Memory - O(N)
     *
     * @param grid - a 2d matrix of elevations of cells.
     * @return - the minimum time until you can reach the bottom right square.
     */
    public int swimInWater(int[][] grid) {
        int height = grid.length;
        int width = grid[0].length;

        int targetRow = height - 1, targetCol = width - 1;

        int[][] neighbours = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        // {maxHeight, row, column}
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        boolean[][] visited = new boolean[height][width];

        pq.offer(new int[]{grid[0][0], 0, 0});
        visited[0][0] = true;


        while (!pq.isEmpty()) {
            int[] cell = pq.poll();
            int curRow = cell[1], curCol = cell[2];

            if (curRow == targetRow && curCol == targetCol) return cell[0];

            for (int[] neighbour : neighbours) {
                int nextRow = curRow + neighbour[0];
                int nextCol = curCol + neighbour[1];

                if (0 <= nextRow && nextRow < height && 0 <= nextCol && nextCol < width && !visited[nextRow][nextCol]) {
                    pq.offer(new int[]{Math.max(cell[0], grid[nextRow][nextCol]), nextRow, nextCol});
                    visited[nextRow][nextCol] = true;
                }
            }
        }

        return grid[height - 1][width - 1];
    }
}
