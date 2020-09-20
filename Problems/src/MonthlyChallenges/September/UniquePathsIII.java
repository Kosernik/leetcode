package MonthlyChallenges.September;

import MonthlyChallenges.June.UniquePaths;

import java.util.Arrays;

public class UniquePathsIII {
    public static void main(String[] args) {
        UniquePathsIII solution = new UniquePathsIII();
        int[][] grid0 = {
                {1,0,0,0},
                {0,0,0,0},
                {0,0,2,-1}
        };
        System.out.println(solution.uniquePathsIII(grid0));
    }

    /**
     * Counting the number of unique paths in a 2d grid with obstacles. Each path should visit all non-obstacle cells
     * once.
     *
     * @param grid - 2d array where "1" - start of the path, "2" finish of the path, "-1" - obstacle, "0" empty cell.
     * @return - number of unique paths or 0 if there are no paths.
     */
    public int uniquePathsIII(int[][] grid) {
        int toVisit = 0;
        int row = 0;
        int col = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    row = i;
                    col = j;
                }
                if (grid[i][j] != -1) toVisit++;
            }
        }
        grid[row][col] = 3;
        int count = bruteBacktrack(grid, row, col, toVisit-1, 0);
        grid[row][col] = 1;
        return count;
    }

    private int bruteBacktrack(int[][] grid, int row, int col, int toVisit, int visited) {
        if (grid[row][col] == 2) {
            if (toVisit == visited) return 1;
            else return 0;
        }
        int curVal = grid[row][col];
        grid[row][col] = 3;
        int currCount = 0;
        if (row > 0 && (grid[row-1][col] == 0 || grid[row-1][col] == 2)) {
            currCount += bruteBacktrack(grid, row-1, col, toVisit, visited+1);
        }
        if (col > 0 && (grid[row][col-1] == 0 || grid[row][col-1] == 2)) {
            currCount += bruteBacktrack(grid, row, col-1, toVisit, visited+1);
        }
        if (row+1 < grid.length && (grid[row+1][col] == 0 || grid[row+1][col] == 2)) {
            currCount += bruteBacktrack(grid, row+1, col, toVisit, visited+1);
        }
        if (col+1 < grid[0].length && (grid[row][col+1] == 0 || grid[row][col+1] == 2)) {
            currCount += bruteBacktrack(grid, row, col+1, toVisit, visited+1);
        }
        grid[row][col] = curVal;
        return currCount;
    }
}
