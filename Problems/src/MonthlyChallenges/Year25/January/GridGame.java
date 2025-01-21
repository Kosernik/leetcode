package MonthlyChallenges.Year25.January;

public class GridGame {
    public static void main(String[] args) {
        GridGame solution = new GridGame();

        int[][] testGrid = {
                {20, 3, 20, 17, 2, 12, 15, 17, 4, 15},
                {20, 10, 13, 14, 15, 5, 2, 3, 14, 3}
        };
        System.out.println(solution.gridGame(testGrid) == 63);
    }

    /**
     * LeetCode №2017. Grid Game.
     * <p>
     * Complexity - O(N)
     * Memory - O(N)
     *
     * @param grid - a 2d matrix. grid.length = 2.
     * @return - the number of points collected by the second robot.
     */
    public long gridGame(int[][] grid) {
        long result = Long.MAX_VALUE;

        int width = grid[0].length;
        long[] topRowPostSum = new long[width + 1];
        long[] bottomRowPreSum = new long[width + 1];

        for (int top = width - 1, bottom = 0; bottom < width; top--, bottom++) {
            topRowPostSum[top] = topRowPostSum[top + 1] + grid[0][top];
            bottomRowPreSum[bottom + 1] = bottomRowPreSum[bottom] + grid[1][bottom];
        }

        for (int i = 0; i < width; i++) {
            long curRes = Math.max(topRowPostSum[i + 1], bottomRowPreSum[i]);
            result = Math.min(result, curRes);
        }

        return result;
    }
}
