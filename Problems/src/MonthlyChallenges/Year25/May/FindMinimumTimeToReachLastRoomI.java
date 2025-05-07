package MonthlyChallenges.Year25.May;

import java.util.Comparator;
import java.util.PriorityQueue;

public class FindMinimumTimeToReachLastRoomI {

    /**
     * LeetCode №3341. Find Minimum Time to Reach Last Room I.
     * <p>
     * Complexity - O(N*M), N = moveTime height, M = moveTime width.
     * Memory - O(N*M)
     *
     * @param moveTime - a 2d array of positive integers, where moveTime[i][j] represents the minimum time in seconds
     *                 when you can start moving to that room.
     * @return - the minimum time to reach the room (n - 1, m - 1).
     */
    public int minTimeToReach(int[][] moveTime) {
        int height = moveTime.length, width = moveTime[0].length;
        int targetRow = height - 1, targetCol = width - 1;

        int[] neighbours = {0, 1, 0, -1, 0};

        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[0]));
        pq.offer(new long[]{0L, 0, 0});

        boolean[][] visited = new boolean[height][width];
        visited[0][0] = true;

        while (!pq.isEmpty()) {
            long[] curCell = pq.poll();

            long curPrice = curCell[0];
            int curRow = (int) curCell[1], curCol = (int) curCell[2];

            if (curRow == targetRow && curCol == targetCol) {
                return Math.max(moveTime[targetRow][targetCol] + 1, (int) curPrice);
            }

            curPrice++;

            for (int i = 0; i < 4; i++) {
                int nextRow = curRow + neighbours[i];
                int nextCol = curCol + neighbours[i + 1];

                if (0 <= nextRow && nextRow < height && 0 <= nextCol && nextCol < width && !visited[nextRow][nextCol]) {
                    int timeRequired = moveTime[nextRow][nextCol] + 1;

                    pq.offer(new long[]{Math.max(curPrice, timeRequired), nextRow, nextCol});
                    visited[nextRow][nextCol] = true;
                }
            }
        }

        return -1;
    }
}
