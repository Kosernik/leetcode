package MonthlyChallenges.June21;

public class StoneGameVII {

    private Integer[][] computed;

    /**
     * LeetCode #1690.
     *
     *
     * @param stones - an array of integers, representing values of each stone.
     * @return - result of a game.
     */
    public int stoneGameVII(int[] stones) {
        this.computed = new Integer[stones.length][stones.length];
        int[] preSums = new int[stones.length+1];
        preSums[0] = 0;
        for (int i = 0; i < stones.length; i++) {
            preSums[i+1] = preSums[i] + stones[i];
        }

        return pickStone(stones, 0, stones.length-1, preSums);
    }

    private int pickStone(int[] stones, int start, int end, int[] preSums) {
        if (end == start) {
            return 0;
        } else if (this.computed[start][end] != null) {
            return this.computed[start][end];
        }

        int scoreRemoveRight = preSums[end] - preSums[start];
        int scoreRemoveLeft = preSums[end+1] - preSums[start+1];

        int resRemoveLeft = pickStone(stones, start+1, end, preSums);
        int resRemoveRight = pickStone(stones, start, end-1, preSums);

        int result = Math.max((scoreRemoveRight - resRemoveRight), (scoreRemoveLeft - resRemoveLeft));
        this.computed[start][end] = result;

        return result;
    }
}
