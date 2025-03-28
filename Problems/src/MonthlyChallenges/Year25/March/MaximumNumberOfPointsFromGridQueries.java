package MonthlyChallenges.Year25.March;

import java.util.*;

public class MaximumNumberOfPointsFromGridQueries {

    /**
     * LeetCode №2503. Maximum Number of Points From Grid Queries.
     *
     * @param grid    - a 2d array of positive integers.
     * @param queries - an array of positive integers.
     * @return - the result for the queries.
     */
    public int[] maxPoints(int[][] grid, int[] queries) {
        int length = queries.length;
        int[] points = new int[length];

        int height = grid.length, width = grid[0].length;
        int[] neighbours = {0, 1, 0, -1, 0};

        Map<Integer, List<Integer>> indices = new HashMap<>();
        for (int i = 0; i < length; i++) {
            int query = queries[i];
            if (!indices.containsKey(query)) {
                indices.put(query, new ArrayList<>());
            }

            indices.get(query).add(i);
        }

        Arrays.sort(queries);

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> getValue(a, grid)));
        pq.offer(new int[]{0, 0});

        boolean[][] visited = new boolean[height][width];
        visited[0][0] = true;

        int queryIdx = 0;

        int currentPoints = 0;

        while (queryIdx < length) {
            int queryValue = queries[queryIdx];
            while ((queryIdx + 1) < length && queries[queryIdx + 1] == queryValue) {
                queryIdx++;
            }

            while (!pq.isEmpty() && getValue(pq.peek(), grid) < queryValue) {
                int[] cell = pq.poll();

                currentPoints++;

                for (int i = 0; i < 4; i++) {
                    int nextRow = cell[0] + neighbours[i];
                    int nextCol = cell[1] + neighbours[i + 1];

                    if (0 <= nextRow && nextRow < height
                            && 0 <= nextCol && nextCol < width
                            && !visited[nextRow][nextCol]) {
                        pq.offer(new int[]{nextRow, nextCol});
                        visited[nextRow][nextCol] = true;
                    }
                }
            }

            for (int idx : indices.get(queryValue)) {
                points[idx] = currentPoints;
            }

            queryIdx++;
        }

        return points;
    }

    private int getValue(int[] coordinates, int[][] grid) {
        return grid[coordinates[0]][coordinates[1]];
    }
}
