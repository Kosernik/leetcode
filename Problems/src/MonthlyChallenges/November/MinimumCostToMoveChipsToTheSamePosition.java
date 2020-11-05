package MonthlyChallenges.November;

import java.util.Arrays;

public class MinimumCostToMoveChipsToTheSamePosition {
    public static void main(String[] args) {
        MinimumCostToMoveChipsToTheSamePosition solution = new MinimumCostToMoveChipsToTheSamePosition();
        int[] tst0 = {1,2,3};
        int[] tst1 = {2,2,2,3,3};

        System.out.println(solution.minCostToMoveChips(tst0) == 1);
        System.out.println(solution.minCostToMoveChips(tst1) == 2);
    }

    /**
     * Returns the minimum cost needed to move all the chips to the same position.
     * Cost of moving from position[i] to position[i]+2 = 0, position[i]-2 = 0.
     * Cost of moving from position[i] to position[i]+1 = 1, position[i]-1 = 1.
     * Position of i-th chip is position[i].
     *
     * Complexity - O(N)
     * Memory - O(1)
     *
     * @param position - array of integers, representing positions of chips.
     * @return - minimum cost of moving all chips to the same position.
     */
    public int minCostToMoveChips(int[] position) {
        int[] moved = new int[2];

        for (int j : position) {
            if (j % 2 == 0) {
                moved[0]++;
            } else {
                moved[1]++;
            }
        }

        return Math.min(moved[0], moved[1]);
    }
}
