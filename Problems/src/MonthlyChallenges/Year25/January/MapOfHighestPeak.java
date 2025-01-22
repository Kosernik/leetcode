package MonthlyChallenges.Year25.January;

import java.util.ArrayDeque;
import java.util.Deque;

public class MapOfHighestPeak {

    /**
     * LeetCode №1765. Map of Highest Peak.
     * <p>
     * Complexity - O(N)
     * Memory - O(N)
     *
     * @param isWater - a 2d matrix of 0 and 1. 0 means a cell is land, 1 means a cell is water.
     * @return - an assignment of heights such that the maximum height in the matrix is maximized.
     */
    public int[][] highestPeak(int[][] isWater) {
        int height = isWater.length, width = isWater[0].length;
        int[][] result = new int[height][width];

        Deque<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[height][width];

        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                if (isWater[row][col] == 1) {
                    queue.offer(new int[]{row, col});
                    visited[row][col] = true;
                }
            }
        }

        int[][] neighbours = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        int level = 0;
        while (!queue.isEmpty()) {
            for (int i = queue.size(); i > 0; i--) {
                int[] cell = queue.removeFirst();
                int row = cell[0], col = cell[1];

                result[row][col] = level;

                for (int[] neighbour : neighbours) {
                    int nextRow = row + neighbour[0];
                    int nextCol = col + neighbour[1];

                    if (0 <= nextRow && nextRow < height &&
                            0 <= nextCol && nextCol < width &&
                            !visited[nextRow][nextCol]) {
                        visited[nextRow][nextCol] = true;
                        queue.offerLast(new int[]{nextRow, nextCol});
                    }
                }
            }

            level++;
        }

        return result;
    }
}
