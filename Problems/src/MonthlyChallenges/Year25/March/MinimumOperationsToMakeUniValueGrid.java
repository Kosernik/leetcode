package MonthlyChallenges.Year25.March;

import java.util.ArrayList;
import java.util.List;

public class MinimumOperationsToMakeUniValueGrid {

    /**
     * LeetCode №2033. Minimum Operations to Make a Uni-Value Grid.
     * <p>
     * Complexity - O(NlogN), N = grid.height * grid.width
     * Memory - O(N)
     *
     * @param grid - a 2d array of positive integers.
     * @param x    - a positive integer.
     * @return -  the minimum number of operations to make the grid uni-value. If it is not possible, returns -1.
     */
    public int minOperations(int[][] grid, int x) {
        int height = grid.length, width = grid[0].length;
        List<Integer> values = new ArrayList<>(height * width);

        int remainder = grid[0][0] % x;

        for (int[] row : grid) {
            for (int col = 0; col < width; col++) {
                int value = row[col];

                if (value % x != remainder) return -1;

                values.add(value);
            }
        }

        values.sort(Integer::compare);

        int operations = 0;

        int leftIdx = 0, rightIdx = height * width - 1;
        while (leftIdx < rightIdx) {
            int left = values.get(leftIdx);
            int right = values.get(rightIdx);

            operations += (right - left) / x;

            leftIdx++;
            rightIdx--;
        }

        return operations;
    }
}
