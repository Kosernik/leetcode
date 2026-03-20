package MonthlyChallenges.Year26.March;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MinimumAbsoluteDifferenceInSlidingSubmatrix {

    /**
     * LeetCode №3567. Minimum Absolute Difference in Sliding Submatrix.
     *
     * @param grid - a square matrix of size N * M.
     * @param k    - a positive integer. 1 <= k <= min(N, M)
     * @return - a 2d array of minimum absolute differences in submatrices of size k*k.
     */
    public int[][] minAbsDiff(int[][] grid, int k) {
        int height = grid.length, width = grid[0].length;

        int[][] result = new int[height - k + 1][width - k + 1];

        for (int i = 0; i < (height - k + 1); i++) {
            for (int j = 0; j < (width - k + 1); j++) {
                List<Integer> values = getList(i, j, grid, k);

                result[i][j] = getMinAbsDiff(values);
            }
        }

        return result;
    }


    private List<Integer> getList(int row, int col, int[][] grid, int k) {
        List<Integer> values = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            for (int j = 0; j < k; j++) {
                values.add(grid[row + i][col + j]);
            }
        }

        return values;
    }

    private int getMinAbsDiff(List<Integer> values) {
        Collections.sort(values);

        int minDiff = Integer.MAX_VALUE;

        for (int i = 1; i < values.size(); i++) {
            int curDiff = values.get(i) - values.get(i - 1);
            if (curDiff != 0) {
                minDiff = Math.min(minDiff, curDiff);
            }
        }

        return minDiff == Integer.MAX_VALUE ? 0 : minDiff;
    }
}
