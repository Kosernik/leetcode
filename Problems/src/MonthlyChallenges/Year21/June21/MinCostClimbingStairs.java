package MonthlyChallenges.Year21.June21;

public class MinCostClimbingStairs {
    public static void main(String[] args) {
        MinCostClimbingStairs solution = new MinCostClimbingStairs();

        int[][] tests = {
                {10, 15, 20},
                {1, 100, 1, 1, 1, 100, 1, 1, 100, 1},
                {1, 2, 3, 4, 5, 6, 7, 8, 9, 8, 7, 6, 5, 4, 3, 2, 1},
                {0, 0, 0, 0, 0, 0, 7, 0, 8, 0, 0, 0, 9, 0, 0, 0, 7}
        };
    }

    /**
     * LeetCode #746.
     * <p>
     * Complexity - O(N)
     * Memory - O(N)
     *
     * @param cost - an array of non-negative integers.
     * @return - the minimum cost to reach the top of the floor.
     */
    public int minCostClimbingStairs(int[] cost) {
        int[] steps = new int[cost.length];
        steps[0] = cost[0];
        steps[1] = cost[1];

        for (int i = 2; i < steps.length; i++) {
            steps[i] = Math.min(steps[i - 1], steps[i - 2]) + cost[i];
        }

        return Math.min(steps[steps.length - 1], steps[steps.length - 2]);
    }
}
