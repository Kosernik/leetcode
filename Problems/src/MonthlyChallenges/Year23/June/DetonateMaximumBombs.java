package MonthlyChallenges.Year23.June;

import java.util.ArrayDeque;
import java.util.Deque;

public class DetonateMaximumBombs {

    /**
     * LeetCode #2101. Detonate the Maximum Bombs.
     * <p>
     * Complexity - O(N^2)
     * Memory - O(N)
     *
     * @param bombs - an array of bombs, bombs[i] = {X coordinate, Y coordinate, explosion radius}
     * @return - the maximum exploded bombs after detonating only one bomb.
     */
    public int maximumDetonation(int[][] bombs) {
        int result = 0;

        for (int i = 0; i < bombs.length; i++) {
            int curBombsDetonated = detonateBomb(i, bombs);
            result = Math.max(result, curBombsDetonated);
        }

        return result;
    }

    private int detonateBomb(int bombIdx, int[][] bombs) {
        int result = 0;
        boolean[] visited = new boolean[bombs.length];

        Deque<Integer> queue = new ArrayDeque<>();
        queue.offer(bombIdx);
        visited[bombIdx] = true;

        while (!queue.isEmpty()) {
            int curBombIdx = queue.poll();
            result++;

            for (int i = 0; i < bombs.length; i++) {
                if (!visited[i] && isInRange(bombs[curBombIdx], bombs[i])) {
                    visited[i] = true;
                    queue.offer(i);
                }
            }
        }

        return result;
    }

    private boolean isInRange(int[] bomb, int[] candidate) {
        long explosionRadiusSqr = bomb[2] * (long) bomb[2];

        long xDistance = Math.abs(bomb[0] - candidate[0]);
        long yDistance = Math.abs(bomb[1] - candidate[1]);

        return (xDistance * xDistance + yDistance * yDistance) <= explosionRadiusSqr;
    }
}
