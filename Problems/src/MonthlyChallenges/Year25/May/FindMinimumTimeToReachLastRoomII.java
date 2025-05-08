package MonthlyChallenges.Year25.May;

import org.jetbrains.annotations.NotNull;

import java.util.PriorityQueue;

public class FindMinimumTimeToReachLastRoomII {

    /**
     * LeetCode №3342. Find Minimum Time to Reach Last Room II.
     * <p>
     * Complexity - O(NlogN)
     * Memory - O(N)
     *
     * @param moveTime - a 2d array of positive integers, where moveTime[i][j] represents the minimum time in seconds
     *                 when you can start moving to that room. Moving between adjacent rooms takes one second for one
     *                 move and two seconds for the next, alternating between the two.
     * @return - the minimum time to reach the room (n - 1, m - 1).
     */
    public int minTimeToReach(int[][] moveTime) {
        int[][] neighbours = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        int height = moveTime.length, width = moveTime[0].length;

        boolean[][] visited = new boolean[height][width];
        visited[0][0] = true;

        int targetRow = height - 1, targetCol = width - 1;

        PriorityQueue<Move> pq = new PriorityQueue<>();
        pq.offer(new Move(0, 0, 0, false));

        while (!pq.isEmpty()) {
            Move move = pq.poll();

            if (move.row == targetRow && move.col == targetCol) return (int) move.time;

            for (int[] neighbour : neighbours) {
                int nextRow = move.row + neighbour[0];
                int nextCol = move.col + neighbour[1];

                if (0 <= nextRow && nextRow < height && 0 <= nextCol && nextCol < width && !visited[nextRow][nextCol]) {
                    visited[nextRow][nextCol] = true;
                    long time = Math.max(moveTime[nextRow][nextCol], move.time) + (move.evenMove ? 2 : 1);

                    pq.offer(new Move(time, nextRow, nextCol, !move.evenMove));
                }
            }
        }

        return -1;
    }

    static class Move implements Comparable<Move> {
        long time;
        int row;
        int col;
        boolean evenMove;

        Move(long time, int row, int col, boolean oddMove) {
            this.time = time;
            this.row = row;
            this.col = col;
            this.evenMove = oddMove;
        }

        @Override
        public int compareTo(@NotNull Move o) {
            return Long.compare(this.time, o.time);
        }
    }
}
