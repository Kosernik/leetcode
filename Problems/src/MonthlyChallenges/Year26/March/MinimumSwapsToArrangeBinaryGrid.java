package MonthlyChallenges.Year26.March;

import java.util.Arrays;

public class MinimumSwapsToArrangeBinaryGrid {

    /**
     * LeetCode №1536. Minimum Swaps to Arrange a Binary Grid.
     * <p>
     * Complexity - O(N^2)
     * Memory - O(N)
     * <p>
     * A grid is said to be valid if all the cells above the main diagonal are zeros.
     * In one step you can choose two adjacent rows of the grid and swap them.
     *
     * @param grid - a square matrix of size N with 0 and 1.
     * @return - the minimum number of steps needed to make the grid valid, or -1 if the grid cannot be valid.
     */
    public int minSwaps(int[][] grid) {
        int size = grid.length;

        int[] rightOne = new int[size];
        Arrays.fill(rightOne, -1);

        for (int i = 0; i < size; i++) {
            for (int j = size - 1; j >= 0; j--) {
                if (grid[i][j] == 1) {
                    rightOne[i] = j;
                    break;
                }
            }
        }

        int swaps = 0;

        for (int i = 0; i < size; i++) {
            int rawWithEnoughZeroes = -1;

            for (int j = i; j < size; j++) {
                if (rightOne[j] <= i) {
                    swaps += j - i;
                    rawWithEnoughZeroes = j;
                    break;
                }
            }

            if (rawWithEnoughZeroes == -1) {
                return -1;
            } else {
                for (int j = rawWithEnoughZeroes; j > i; j--) {
                    int temp = rightOne[j];
                    rightOne[j] = rightOne[j - 1];
                    rightOne[j - 1] = temp;
                }
            }
        }

        return swaps;
    }
}
