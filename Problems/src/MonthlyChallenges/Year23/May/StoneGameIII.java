package MonthlyChallenges.Year23.May;

public class StoneGameIII {

    /**
     * LeetCode #1406. Stone Game III.
     * <p>
     * Complexity - O(N)
     * Memory - O(N)
     *
     * @param stoneValue - an array of points for each stone.
     * @return - the winner of the game.
     */
    public String stoneGameIII(int[] stoneValue) {
        Integer[] computed = new Integer[stoneValue.length + 1];

        int result = simulation(0, stoneValue, computed);

        if (result > 0) {
            return "Alice";
        } else if (result < 0) {
            return "Bob";
        } else {
            return "Tie";
        }
    }

    private int simulation(int idx, int[] stoneValue, Integer[] computed) {
        if (idx >= stoneValue.length) {
            return 0;
        } else if (computed[idx] != null) {
            return computed[idx];
        }

        int result = Integer.MIN_VALUE;
        int curSum = 0;

        for (int i = 0; i < 3; i++) {
            if (idx + i >= stoneValue.length) break;
            curSum += stoneValue[idx + i];

            int curScore = curSum - simulation(idx + i + 1, stoneValue, computed);
            result = Math.max(result, curScore);
        }

        computed[idx] = result;
        return result;
    }
}
