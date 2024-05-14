package MonthlyChallenges.Year24.May;

public class PathWithMaximumGold {
    public static void main(String[] args) {
        PathWithMaximumGold solution = new PathWithMaximumGold();

        int[][] test2 = {
                {0, 0, 19, 5, 8},
                {11, 20, 14, 1, 0},
                {0, 0, 1, 1, 1},
                {0, 2, 0, 2, 0}
        };

        System.out.println(solution.getMaximumGold(test2));
    }


    private final int[] NEIGHBOURS = {0, 1, 0, -1, 0};

    /**
     * LeetCode №1219. Path with Maximum Gold.
     *
     * @param grid - an N*M matrix.
     * @return - tha maximum amount of gold.
     */
    public int getMaximumGold(int[][] grid) {
        int maxGold = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] != 0) {
                    maxGold = Math.max(maxGold, backTrack(i, j, grid, new boolean[grid.length][grid[0].length]));
                }
            }
        }

        return maxGold;
    }

    private int backTrack(int row, int col, int[][] grid, boolean[][] visited) {
        int result = grid[row][col];
        visited[row][col] = true;

        int neighbourGold = 0;
        for (int i = 0; i < 4; i++) {
            int nextRow = row + NEIGHBOURS[i];
            int nextCol = col + NEIGHBOURS[i + 1];

            if (0 <= nextRow && nextRow < grid.length &&
                    0 <= nextCol && nextCol < grid[0].length &&
                    grid[nextRow][nextCol] != 0 && !visited[nextRow][nextCol]) {
                neighbourGold = Math.max(neighbourGold, backTrack(nextRow, nextCol, grid, visited));
            }
        }

        visited[row][col] = false;
        return result + neighbourGold;
    }
}
