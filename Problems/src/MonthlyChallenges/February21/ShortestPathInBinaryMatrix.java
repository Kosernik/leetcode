package MonthlyChallenges.February21;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Set;

public class ShortestPathInBinaryMatrix {
    /**
     * LeetCode #1091.
     * Returns the length of the shortest path in a binary square matrix from top left corner to bottom right corner.
     *
     * Complexity O(N)
     * Memory - O(N)
     *
     * @param grid - 2d array of values '0' or '1', height=width.
     * @return - the length of the shortest path.
     */
    public int shortestPathBinaryMatrix(int[][] grid) {
        int length = 0;

        int height = grid.length;
        int width = grid[0].length;
        if (grid[0][0] == 1 || grid[height-1][width-1] == 1) return -1;

        ArrayDeque<int[]> queue = new ArrayDeque<>();
        Set<String> visited = new HashSet<>();
        queue.offerLast(new int[] {0,0});
        visited.add("0-0");

        while (!queue.isEmpty()) {
            length++;

            for (int i = queue.size(); i > 0 ; i--) {
                int[] coordinates = queue.removeFirst();
                if (coordinates[0] == (height-1) && coordinates[1] == (width-1)) return length;
                addNeighboursToQueue(grid, coordinates, queue, visited);
            }
        }

        return -1;
    }

    private void addNeighboursToQueue(int[][] grid, int[] coordinate, ArrayDeque<int[]> queue, Set<String> visited) {
        int i = coordinate[0];
        int j = coordinate[1];

        if (i-1 >= 0) {
            if (j-1 >= 0 && grid[i-1][j-1] == 0 && !visited.contains((i-1) + "-" + (j-1))) {
                queue.offerLast(new int[] {i-1, j-1});
                visited.add((i-1) + "-" + (j-1));
            }
            if (grid[i-1][j] == 0 && !visited.contains((i-1) + "-" + j)) {
                queue.offerLast(new int[] {i-1, j});
                visited.add((i-1) + "-" + j);
            }
            if (j+1 < grid[0].length && grid[i-1][j+1] == 0 && !visited.contains((i-1) + "-" + (j+1))) {
                queue.offerLast(new int[] {i-1, j+1});
                visited.add((i-1) + "-" + (j+1));
            }
        }
        if (j-1 >= 0 && grid[i][j-1] == 0 && !visited.contains(i + "-" + (j-1))) {
            queue.offerLast(new int[] {i, j-1});
            visited.add(i + "-" + (j-1));
        }
        if (j+1 < grid[0].length && grid[i][j+1] == 0 && !visited.contains(i + "-" + (j+1))) {
            queue.offerLast(new int[] {i, j+1});
            visited.add(i + "-" + (j+1));
        }
        if (i+1 < grid.length) {
            if (j-1 >= 0 && grid[i+1][j-1] == 0 && !visited.contains((i+1) + "-" + (j-1))) {
                queue.offerLast(new int[] {i+1, j-1});
                visited.add((i+1) + "-" + (j-1));
            }
            if (grid[i+1][j] == 0 && !visited.contains((i+1) + "-" + j)) {
                queue.offerLast(new int[] {i+1, j});
                visited.add((i+1) + "-" + j);
            }
            if (j+1 < grid[0].length && grid[i+1][j+1] == 0 && !visited.contains((i+1) + "-" + (j+1))) {
                queue.offerLast(new int[] {i+1, j+1});
                visited.add((i+1) + "-" + (j+1));
            }
        }
    }
}
