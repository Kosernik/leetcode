package MonthlyChallenges.Year24.May;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.PriorityQueue;

public class FindSafestPathInGrid {

    /**
     * LeetCode №2812. Find the Safest Path in a Grid.
     * <p>
     * Complexity - Dijkstra's complexity
     * Memory - (N*M)
     *
     * @param grid - an array of  0 and 1. 0 - safe cell, 1 - a cell with a thief.
     * @return - the maximum safeness factor of all paths leading from cell (0, 0) to cell (n - 1, m - 1).
     */
    public int maximumSafenessFactor(List<List<Integer>> grid) {
        int height = grid.size();
        int width = grid.get(0).size();
        int[] neighbours = {0, 1, 0, -1, 0};

        int[][] distances = new int[height][width];
        Deque<int[]> thieves = new ArrayDeque<>();

        for (int row = 0; row < height; row++) {
            List<Integer> curRow = grid.get(row);
            for (int col = 0; col < width; col++) {
                if (curRow.get(col) == 1) {
                    thieves.add(new int[]{row, col});
                    distances[row][col] = 0;
                } else {
                    distances[row][col] = -1;
                }
            }
        }

        while (!thieves.isEmpty()) {
            for (int i = thieves.size(); i > 0; i--) {
                int[] cell = thieves.removeFirst();
                int nextDist = distances[cell[0]][cell[1]] + 1;

                for (int j = 0; j < 4; j++) {
                    int nextRow = cell[0] + neighbours[j];
                    int nextCol = cell[1] + neighbours[j + 1];

                    if (0 <= nextRow && nextRow < height && 0 <= nextCol && nextCol < width &&
                            distances[nextRow][nextCol] == -1) {
                        distances[nextRow][nextCol] = nextDist;
                        thieves.offerLast(new int[]{nextRow, nextCol});
                    }
                }
            }
        }


        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(b[2], a[2]));
        pq.offer(new int[]{0, 0, distances[0][0]});
        distances[0][0] = -1;

        while (!pq.isEmpty()) {
            int[] curCell = pq.poll();
            if (curCell[0] == (height - 1) && curCell[1] == (width - 1)) {
                return curCell[2];
            }

            for (int i = 0; i < 4; i++) {
                int nextRow = curCell[0] + neighbours[i];
                int nextCol = curCell[1] + neighbours[i + 1];

                if (0 <= nextRow && nextRow < height && 0 <= nextCol && nextCol < width &&
                        distances[nextRow][nextCol] != -1) {
                    pq.offer(new int[]{nextRow, nextCol, Math.min(curCell[2], distances[nextRow][nextCol])});
                    distances[nextRow][nextCol] = -1;
                }
            }
        }

        return -1;
    }
}
