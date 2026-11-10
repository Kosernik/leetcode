package MonthlyChallenges.Year26.November;

public class ClimbingStairsII {

    /**
     * LeetCode №3693. Climbing Stairs II.
     * <p>
     * Complexity - O(N)
     * Memory - O(1)
     *
     * @param n     - the number of steps minus one. There are n+1 steps.
     * @param costs - a 1-indexed integer array costs of length n, where costs[i] is the cost of step i.
     * @return - the minimum total cost to reach step n.
     */
    public int climbStairs(int n, int[] costs) {
        int singleStep = 1, doubleStep = 4, tripleStep = 9;

        int threeCost = costs[0] + singleStep;
        if (n == 1) return threeCost;

        int twoCost = costs[1] + Math.min(doubleStep, singleStep + threeCost);
        if (n == 2) return twoCost;

        int prevCost = costs[2] + Math.min(tripleStep, Math.min(threeCost + doubleStep, twoCost + singleStep));
        if (n == 3) return prevCost;

        for (int i = 4; i <= n; i++) {
            int curCost = costs[i - 1] + Math.min(threeCost + tripleStep, Math.min(twoCost + doubleStep, prevCost + singleStep));
            threeCost = twoCost;
            twoCost = prevCost;
            prevCost = curCost;
        }

        return prevCost;
    }


    /**
     * LeetCode №3693. Climbing Stairs II.
     * <p>
     * Complexity - O(N)
     * Memory - O(N)
     *
     * @param n     - the number of steps minus one. There are n+1 steps.
     * @param costs - a 1-indexed integer array costs of length n, where costs[i] is the cost of step i.
     * @return - the minimum total cost to reach step n.
     */
    public int climbStairsMemo(int n, int[] costs) {
        int oneStep = 1, twoStep = 4, threeStep = 9;

        int[] dp = new int[n + 1];
        dp[1] = costs[0] + oneStep;
        if (n == 1) return dp[1];

        dp[2] = costs[1] + Math.min(twoStep, oneStep + dp[1]);
        if (n == 2) return dp[2];

        for (int i = 3; i <= n; i++) {
            dp[i] = costs[i - 1] + Math.min(dp[i - 3] + threeStep, Math.min(dp[i - 2] + twoStep, dp[i - 1] + oneStep));
        }

        return dp[n];
    }
}
