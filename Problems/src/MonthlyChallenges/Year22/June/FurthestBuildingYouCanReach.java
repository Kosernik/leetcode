package MonthlyChallenges.Year22.June;

import java.util.PriorityQueue;

public class FurthestBuildingYouCanReach {

    /**
     *  LeetCode #1642. Furthest Building You Can Reach
     *
     *  Complexity - O(N*logL), N = heights.length, L = ladders.
     *  Memory - O(L)
     *
     * @param heights - an array of positive integer.
     * @param bricks - non-negative integer.
     * @param ladders - non-negative integer.
     * @return - the furthest building index (0-indexed) you can reach if you use the given ladders and bricks optimally.
     */
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int bricksUsed = 0;

        for (int i = 0; i < heights.length - 1; i++) {
            if (heights[i] < heights[i+1]) {
                int curHeight = heights[i+1] - heights[i];
                pq.offer(curHeight);

                if (pq.size() > ladders) {
                    int prevBricks = pq.poll();

                    bricksUsed += prevBricks;

                    if (bricksUsed > bricks) return i;
                }
            }
        }

        return heights.length-1;
    }
}
