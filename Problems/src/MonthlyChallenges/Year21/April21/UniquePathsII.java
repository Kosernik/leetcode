package MonthlyChallenges.Year21.April21;

public class UniquePathsII {
    /**
     * LeetCode #63.
     * <p>
     * Complexity - O(N)
     * Memory - O(N)
     *
     * @param obstacleGrid - 2d array of digits '1' and '0'. '1' - obstacle, '0' - empty cell.
     * @return - the total number of unique paths.
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid[0][0] == 1) return 0;
        int height = obstacleGrid.length;
        int width = obstacleGrid[0].length;

        int[][] counts = new int[height][width];
        counts[0][0] = 1;
        obstacleGrid[0][0] = 1;

        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                if (obstacleGrid[row][col] == 0) {
                    int left = col == 0 ? 0 : counts[row][col - 1];
                    int top = row == 0 ? 0 : counts[row - 1][col];
                    counts[row][col] = left + top;
                }
            }
        }

        obstacleGrid[0][0] = 0;
        return counts[height - 1][width - 1];
    }
}
