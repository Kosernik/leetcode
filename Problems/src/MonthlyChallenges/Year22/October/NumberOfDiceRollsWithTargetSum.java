package MonthlyChallenges.Year22.October;

public class NumberOfDiceRollsWithTargetSum {
    public static void main(String[] args) {
        NumberOfDiceRollsWithTargetSum solution = new NumberOfDiceRollsWithTargetSum();

        System.out.println(solution.numRollsToTarget(1, 6, 3) == 1);
        System.out.println(solution.numRollsToTarget(2, 6, 7) == 6);
        System.out.println(solution.numRollsToTarget(30, 30, 500) == 222616187);
    }

    /**
     * LeetCode #1155. Number of Dice Rolls With Target Sum.
     * <p>
     * Complexity - O(n * target * k)
     * Memory - O(n * target)
     *
     * @param n      - the number of dice.
     * @param k-     the number of sides on each die.
     * @param target - the required target sum of sides.
     * @return - the number of ways to roll the dice so the sum of the face-up numbers equals target.
     * Result is modulo 1_000_000_000 + 7.
     */
    public int numRollsToTarget(int n, int k, int target) {
        if (target < n || target > (n * k)) return 0;

        int MODULO = 1_000_000_000 + 7;

        int[][] dp = new int[n + 1][target + 1];
        for (int i = 1; i <= Math.min(k, target); i++) {
            dp[1][i] = 1;
        }

        for (int die = 2; die <= n; die++) {
            for (int sum = die; sum <= target; sum++) {
                int prevSum = 0;
                for (int side = 1; side <= k; side++) {
                    if ((sum - side) >= 0 && dp[die - 1][sum - side] > 0) {
                        prevSum = (prevSum + dp[die - 1][sum - side]) % MODULO;
                    }
                }

                dp[die][sum] = (dp[die][sum] + prevSum) % MODULO;
            }
        }

        return dp[n][target];
    }
}
