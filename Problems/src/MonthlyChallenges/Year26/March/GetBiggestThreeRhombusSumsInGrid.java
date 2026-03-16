package MonthlyChallenges.Year26.March;

public class GetBiggestThreeRhombusSumsInGrid {

    /**
     * LeetCode №1878. Get Biggest Three Rhombus Sums in a Grid.
     * <p>
     * Complexity - O(N*M), N = grid.length, M = grid[i].length.
     * Memory - O(N*M)
     *
     * @param grid - a 2d array of positive integers.
     * @return - the biggest three distinct rhombus sums in the grid in descending order. If there are less than three
     * distinct values, returns all of them.
     */
    public int[] getBiggestThree(int[][] grid) {
        int height = grid.length, width = grid[0].length;

        int[][][] prefixSums = new int[height + 1][width + 2][2];   //  {leftToRight, rightToLeft}

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                int curNumber = grid[i][j];

                prefixSums[i + 1][j + 1][0] += prefixSums[i][j][0] + curNumber;
                prefixSums[i + 1][j + 1][1] += prefixSums[i][j + 2][1] + curNumber;
            }
        }

        int[] result = new int[]{0, 0, 0};

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                updateMaxes(grid[i][j], result);

                for (int k = j + 2; k < width; k += 2) {
                    int side = (k - j) / 2;

                    int middleColumn = j + side;

                    int topRowIdx = i - side;
                    int bottomRowIdx = i + side;

                    if (topRowIdx < 0 || bottomRowIdx >= height) continue;

                    int candidateSum = (prefixSums[i + 1][j + 1][1] - prefixSums[topRowIdx][middleColumn + 2][1]) +
                            (prefixSums[i + 1][k + 1][0] - prefixSums[topRowIdx + 1][middleColumn + 1][0]) +
                            (prefixSums[bottomRowIdx + 1][middleColumn + 1][1] - prefixSums[i + 1][k + 1][1]) +
                            (prefixSums[bottomRowIdx + 1][middleColumn + 1][0] - prefixSums[i + 1][j + 1][0]) -
                            grid[i + side][middleColumn];

                    updateMaxes(candidateSum, result);
                }
            }
        }

        return getUnique(result);
    }

    private void updateMaxes(int candidate, int[] maxSums) {
        if (candidate == maxSums[0] || candidate == maxSums[1] || candidate == maxSums[2]) return;
        if (candidate > maxSums[0]) {
            maxSums[2] = maxSums[1];
            maxSums[1] = maxSums[0];
            maxSums[0] = candidate;
        } else if (candidate > maxSums[1]) {
            maxSums[2] = maxSums[1];
            maxSums[1] = candidate;
        } else if (candidate > maxSums[2]) {
            maxSums[2] = candidate;
        }
    }

    private int[] getUnique(int[] maxSums) {
        if (maxSums[1] == 0) {
            return new int[]{maxSums[0]};
        } else if (maxSums[2] == 0) {
            return new int[]{maxSums[0], maxSums[1]};
        } else {
            return maxSums;
        }
    }
}
