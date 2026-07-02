package MonthlyChallenges.Year26.July;

import java.util.List;
import java.util.PriorityQueue;

public class FindSafeWalkThroughGrid {

    /**
     * LeetCode №3286. Find a Safe Walk Through a Grid.
     * <p>
     * Complexity - O(N*M * logNM)
     * Memory - O(N*M)
     *
     * @param grid   - a 2d matrix of 0 and 1. 0 - the cell is safe, 1 - you lose 1 health.
     * @param health - initial health.
     * @return - true if you can reach the cell at row = (height - 1) and row = (width - 1) with a health value of 1 or
     * more, and false otherwise.
     */
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int height = grid.size();
        int width = grid.get(0).size();

        int[][] neighbours = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0]));
        pq.offer(new int[]{health - grid.get(0).get(0), 0, 0});

        boolean[][] visited = new boolean[height][width];
        visited[0][0] = true;

        int targetRow = height - 1;
        int targetCol = width - 1;

        while (!pq.isEmpty()) {
            int[] cell = pq.poll();
            int row = cell[1], col = cell[2];
            if (row == targetRow && col == targetCol) {
                return cell[0] >= 1;
            }

            for (int[] neighbour : neighbours) {
                int nextRow = row + neighbour[0];
                int nextCol = col + neighbour[1];

                if (0 <= nextRow && nextRow < height && 0 <= nextCol && nextCol < width && !visited[nextRow][nextCol]
                        && (cell[0] - grid.get(nextRow).get(nextCol) > 0)
                ) {
                    pq.offer(new int[]{cell[0] - grid.get(nextRow).get(nextCol), nextRow, nextCol});
                    visited[nextRow][nextCol] = true;
                }
            }
        }

        return false;
    }
}
